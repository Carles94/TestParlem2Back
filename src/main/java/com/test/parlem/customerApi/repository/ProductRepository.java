package com.test.parlem.customerApi.repository;

import com.test.parlem.customerApi.models.entity.ProductEntity;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
    
}
