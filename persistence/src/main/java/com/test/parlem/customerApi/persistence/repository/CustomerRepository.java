package com.test.parlem.customerApi.persistence.repository;

import com.test.parlem.customerApi.persistence.models.entity.CustomerEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<CustomerEntity, Integer>{

    CustomerEntity findByCustomerId(String customerId);
    
}
