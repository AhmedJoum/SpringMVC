package com.example.demo.OrderProducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRep orderProductRep;

    public List<OrderProducts> getOrderProduct() { return orderProductRep.findAll(); }
    }