package com.test.parlem.customerApi.repository;

import com.test.parlem.customerApi.models.entity.CustomerEntity;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository  extends CrudRepository<CustomerEntity, Integer>{

    CustomerEntity findByCustomerId(String customerId);
    
}
