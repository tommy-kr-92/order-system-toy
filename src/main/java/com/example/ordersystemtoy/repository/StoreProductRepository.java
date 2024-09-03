package com.example.ordersystemtoy.repository;

import com.example.ordersystemtoy.domain.StoreProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer> {
    Optional<StoreProduct> findByStoreIdAndProductId(Integer storeId, Integer productId);
}
