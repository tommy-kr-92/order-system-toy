package com.example.ordersystemtoy.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Table(name = "orders")
public class Order {
    @Id
    private int orderId;

    @Column
    private int customerId;

    @Column
    private Timestamp orderedAt;

    @MappedCollection(idColumn = "order_id", keyColumn = "order_item_id")   // order과 order_item가 연결 되어있다는 걸 알려주기 위한 어노테이션
    private Set<OrderItem> orderItems = new HashSet<>();

    public Order(int customerId, Set<OrderItem> orderItems) {
        this.customerId = customerId;
        this.orderedAt = Timestamp.valueOf(LocalDateTime.now());
        this.orderItems = orderItems;
    }

    public static Order newOrder(CreateOrder createOrder){
        Set<OrderItem> items = new HashSet<>();

        for(Map.Entry<Integer, Integer> entry : createOrder.getQuantityByProduct().entrySet()) {
            items.add(new OrderItem(entry.getKey(), entry.getValue()));
        }

        return new Order(createOrder.getCustomerId(), items);
    }
}
