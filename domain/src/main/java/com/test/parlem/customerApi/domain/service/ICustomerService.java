package com.test.parlem.customerApi.domain.service;

import com.test.parlem.customerApi.domain.models.dto.CustomerDTO;

public interface ICustomerService {
    CustomerDTO getCustomer(String customerId);
}
