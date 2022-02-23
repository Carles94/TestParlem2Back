package com.test.parlem.customerApi.api.controller;

import com.test.parlem.customerApi.domain.models.dto.CustomerDTO;
import com.test.parlem.customerApi.domain.service.ICustomerService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "api/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private ICustomerService customerService;

    public CustomerController(ICustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(value="{customerId}",produces = "application/json")
    public @ResponseBody CustomerDTO getCustomer(@PathVariable String customerId){
        return  customerService.getCustomer(customerId);
    }
}
