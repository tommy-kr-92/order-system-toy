package com.example.ordersystemtoy.service;

import com.example.ordersystemtoy.domain.CreateCustomer;
import com.example.ordersystemtoy.domain.Customer;
import com.example.ordersystemtoy.domain.CustomerDTO;
import com.example.ordersystemtoy.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerDTO newCustomer(CreateCustomer customer) {
        Customer entity = Customer.newCustomer(customer);
        Customer saved = customerRepository.save(entity);
        return CustomerDTO.builder()
                .address(saved.getAddress())
                .name(saved.getName())
                .phoneNumber(saved.getPhoneNumber())
                .build();
    }
}
