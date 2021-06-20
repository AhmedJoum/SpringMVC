package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRep productRep;

    public List<Product> getProduct() {
        return productRep.findAll();
    }
}