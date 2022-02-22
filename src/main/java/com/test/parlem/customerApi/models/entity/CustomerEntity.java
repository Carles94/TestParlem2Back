package com.test.parlem.customerApi.models.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private Integer id;
    private String docType;
    private String docNum;
    private String email;
    private String customerId;
    private String givenName;
    private String familyName1;
    private String phone;
    @OneToMany(targetEntity = ProductEntity.class, fetch = FetchType.EAGER)
    private List<ProductEntity> hiredProductList;
}
