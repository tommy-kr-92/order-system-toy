package com.example.ordersystemtoy.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerDTO {
    private final String name;
    private final String address;
    private final String phoneNumber;
}
