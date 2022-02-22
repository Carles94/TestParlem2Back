package com.test.parlem.customerApi.domain.models.dto;

import lombok.Data;

@Data
public class ProductDTO {
   private String productName;
    private String productTypeName;
    private int numeracioTerminal;
    private String soldAt;
}
