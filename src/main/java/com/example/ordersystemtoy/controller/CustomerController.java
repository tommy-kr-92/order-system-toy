package com.example.ordersystemtoy.controller;

import com.example.ordersystemtoy.domain.CreateCustomer;
import com.example.ordersystemtoy.domain.Customer;
import com.example.ordersystemtoy.domain.CustomerDTO;
import com.example.ordersystemtoy.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/v1/customers")
    public Response<CustomerDTO> createNewCustomer(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) {
        return Response.success(customerService.newCustomer(
                        CreateCustomer.builder()
                                .address(address)
                                .name(name)
                                .phoneNumber(phoneNumber)
                                .build()
                )
        );
    }
}
