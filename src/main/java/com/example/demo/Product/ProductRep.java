package com.example.demo.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRep extends JpaRepository<Product, Long> {
    @Query(value = "select * from product p where p.product_name like concat('%',?1,'%') or p.description like concat('%',?1,'%')", nativeQuery = true)
    List<Product> search(String key);
}