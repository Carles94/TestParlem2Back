package com.test.parlem.customerApi.persistence.models.entity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    private Integer id;
    private String customerId;
    private String productName;
    private String productTypeName;
    private int numeracioTerminal;
    private ZonedDateTime soldAt;   
}
