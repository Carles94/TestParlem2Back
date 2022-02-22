package com.test.parlem.customerApi.domain.service;

import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.test.parlem.customerApi.domain.models.dto.CustomerDTO;
import com.test.parlem.customerApi.persistence.models.entity.CustomerEntity;
import com.test.parlem.customerApi.persistence.models.entity.ProductEntity;
import com.test.parlem.customerApi.persistence.repository.CustomerRepository;
import com.test.parlem.customerApi.persistence.repository.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    // Class to test
    private CustomerService customerService;

    // Mocks
    private CustomerRepository customerRepository;

    @BeforeEach
    public void init(@Mock CustomerRepository customerRepository, @Mock ProductRepository productRepository){
        this.customerRepository = customerRepository;
        customerService = new CustomerService(customerRepository, productRepository);
    }
    
    @Test
    void testGetCustomer(){
        // Arrange
        CustomerEntity customer = createCustomer();
        when(customerRepository.findByCustomerId(customer.getCustomerId())).thenReturn(customer);
        // Act
        CustomerDTO result = customerService.getCustomer(customer.getCustomerId());
        // Assert
        Assertions.assertEquals(customer.getCustomerId(), result.getCustomerId());
        Assertions.assertEquals(customer.getDocNum(), result.getDocNum());
        Assertions.assertEquals(customer.getDocType(), result.getDocType());
        Assertions.assertEquals(customer.getEmail(), result.getEmail());
        Assertions.assertEquals(customer.getFamilyName1(), result.getFamilyName1());
        Assertions.assertEquals(customer.getGivenName(), result.getGivenName());
        Assertions.assertEquals(customer.getPhone(), result.getPhone());

        Assertions.assertEquals(2, result.getHiredProductList().size());

        Assertions.assertEquals(customer.getHiredProductList().get(0).getNumeracioTerminal(), result.getHiredProductList().get(0).getNumeracioTerminal());
        Assertions.assertEquals(customer.getHiredProductList().get(0).getProductName(), result.getHiredProductList().get(0).getProductName());
        Assertions.assertEquals(customer.getHiredProductList().get(0).getProductTypeName(), result.getHiredProductList().get(0).getProductTypeName());
        Pattern datePattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})");
        Assertions.assertTrue(datePattern.matcher(result.getHiredProductList().get(0).getSoldAt()).matches());

        Assertions.assertEquals(customer.getHiredProductList().get(1).getNumeracioTerminal(), result.getHiredProductList().get(1).getNumeracioTerminal());
        Assertions.assertEquals(customer.getHiredProductList().get(1).getProductName(), result.getHiredProductList().get(1).getProductName());
        Assertions.assertEquals(customer.getHiredProductList().get(1).getProductTypeName(), result.getHiredProductList().get(1).getProductTypeName());
        Assertions.assertTrue(datePattern.matcher(result.getHiredProductList().get(1).getSoldAt()).matches());

    }

    private CustomerEntity createCustomer() {
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
        List<ProductEntity> hiredProductList = new ArrayList<>();
        hiredProductList.add(product);
        hiredProductList.add(product2);
        customer.setHiredProductList(hiredProductList);
        return customer;
    }
}
