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

    public void Add(Product product) {
        productRep.save(product);
    }

    public Product getById(Long id) {
        var product = productRep.getById(id);
        return product;
    }

    public List<Product> search(String key) {
        var products = productRep.search(key);
        return products;
    }
}