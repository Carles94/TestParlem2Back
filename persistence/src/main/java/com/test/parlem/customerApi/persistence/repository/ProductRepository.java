package com.test.parlem.customerApi.persistence.repository;

import com.test.parlem.customerApi.persistence.models.entity.ProductEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
    
}
