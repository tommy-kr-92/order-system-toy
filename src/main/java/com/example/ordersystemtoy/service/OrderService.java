package com.example.ordersystemtoy.service;

import com.example.ordersystemtoy.domain.CreateOrder;
import com.example.ordersystemtoy.domain.Order;
import com.example.ordersystemtoy.domain.StoreProduct;
import com.example.ordersystemtoy.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final StoreService storeService;

    public OrderService(OrderRepository orderRepository, StoreService storeService) {
        this.orderRepository = orderRepository;
        this.storeService = storeService;
    }

    public void newOrder(CreateOrder createOrder) {
        List<StoreProduct> storeProducts = new ArrayList<>();

//        재고 데이터를 위한 소스
        for(Map.Entry<Integer, Integer> entry: createOrder.getQuantityByProduct().entrySet()){
            Integer productId = entry.getKey();
            Integer buyQuantity = entry.getValue();

            StoreProduct storeProduct = storeService.getStoreProduct(
                    createOrder.getStoreId(),
                    productId
            );

            int stockQuantity = storeProduct.getStockQuantity();

            if(buyQuantity > stockQuantity) {
                throw new RuntimeException("재고가 없습니다.");
            }

            storeProduct.adjustStockQuantity(buyQuantity);
            storeProducts.add(storeProduct);
        }

        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
        storeService.saveAll(storeProducts);
    }
}
