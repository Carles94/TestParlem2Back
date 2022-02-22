package com.test.parlem.customerApi.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.test.parlem.customerApi.models.dto.CustomerDTO;
import com.test.parlem.customerApi.models.dto.ProductDTO;
import com.test.parlem.customerApi.models.entity.CustomerEntity;
import com.test.parlem.customerApi.models.entity.ProductEntity;
import com.test.parlem.customerApi.repository.CustomerRepository;
import com.test.parlem.customerApi.repository.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    public CustomerService(CustomerRepository customerRepository, ProductRepository productRepository){
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        fillDatabase();
    }

    public CustomerDTO getCustomer(String customerId) {
        CustomerEntity customer = customerRepository.findByCustomerId(customerId) ;
        return mapCustomerToCustomerDTO(customer);
    }

    private CustomerDTO mapCustomerToCustomerDTO(CustomerEntity customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setDocNum(customer.getDocNum());
        customerDTO.setDocType(customer.getDocType());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setFamilyName1(customer.getFamilyName1());
        customerDTO.setGivenName(customer.getGivenName());
        customerDTO.setPhone(customer.getPhone());
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(ProductEntity p : customer.getHiredProductList()){
            productDTOList.add(mapProductToProductDTO(p));
        }
        customerDTO.setHiredProductList(productDTOList);
        return customerDTO;
    }

    private ProductDTO mapProductToProductDTO(ProductEntity product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNumeracioTerminal(product.getNumeracioTerminal());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductTypeName(product.getProductTypeName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        productDTO.setSoldAt(product.getSoldAt().format(formatter));
        return productDTO;
    }



    private void fillDatabase() {
        CustomerEntity customer = new CustomerEntity();
        customer.setCustomerId("11111");
        customer.setDocNum("11223344E");
        customer.setDocType("nif");
        customer.setEmail("it@parlem.com");
        customer.setGivenName("Enriqueta");
        customer.setFamilyName1("Parlem");
        customer.setPhone("668668668");
        customer.setId(555555);
        ProductEntity product = new ProductEntity();
        product.setProductName("productName");
        product.setProductTypeName("productType");
        product.setNumeracioTerminal(1234567);
        product.setSoldAt(ZonedDateTime.now());
        product.setId(11111111);
        product.setCustomerId("11111");
        ProductEntity product2 = new ProductEntity();
        product2.setProductName("productName2");
        product2.setProductTypeName("productType2");
        product2.setNumeracioTerminal(988765);
        product2.setSoldAt(ZonedDateTime.now());
        product2.setId(222222);
        product2.setCustomerId("11111");
        customerRepository.save(customer);
        productRepository.save(product);
        productRepository.save(product2);
        List<ProductEntity> hiredProductList = new ArrayList<>();
        hiredProductList.add(product);
        hiredProductList.add(product2);
        customer.setHiredProductList(hiredProductList);
        customerRepository.save(customer);
    }
}
