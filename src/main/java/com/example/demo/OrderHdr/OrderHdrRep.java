package com.example.demo.OrderHdr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHdrRep extends JpaRepository<OrderHdr, Long> {
}