package com.example.demo.OrderProducts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRep extends JpaRepository<OrderProducts, Long> {
}
