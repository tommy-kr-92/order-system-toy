package com.example.ordersystemtoy.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "customers")
public class Customer {
    @Id
    private int customerId;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // 새로운 Customer를 만들 때 사용
    public static Customer newCustomer(CreateCustomer customer) {
        return new Customer(customer.getName(), customer.getAddress(), customer.getPhoneNumber());
    }
}
