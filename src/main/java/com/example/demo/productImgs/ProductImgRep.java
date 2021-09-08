package com.example.demo.ProductImgs;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImgRep extends JpaRepository<ProductImgs, Long> {
    @Query(value = "select * product_imgs where product_id = ?1", nativeQuery = true)
    List<ProductImgs> getByProductId(Long productId);
}
