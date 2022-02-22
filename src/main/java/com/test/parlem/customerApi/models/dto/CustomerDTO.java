package com.test.parlem.customerApi.models.dto;

import java.util.List;

import lombok.Data;

@Data
public class CustomerDTO {

    private String docType;
    private String docNum;
    private String email;
    private String customerId;
    private String givenName;
    private String familyName1;
    private String phone;
    private List<ProductDTO> hiredProductList;
}
