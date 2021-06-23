package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping(path = "/product")

public class ProductCont {

    private final ProductService productService;

    @Autowired
    public ProductCont(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/search")
    public String getProduct(@ModelAttribute("keyword") String keyword, 
    Model model) {
       
        List<Product> products = productService.search(keyword);
        model.addAttribute("products", products);
        return "Shop";
    }
}
