package com.test.parlem.customerApi.models.dto;

import lombok.Data;

@Data
public class ProductDTO {
   private String productName;
    private String productTypeName;
    private int numeracioTerminal;
    private String soldAt;
}
