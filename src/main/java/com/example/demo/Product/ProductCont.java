package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

import com.example.demo.User.User;

@Controller
@RequestMapping(path = "/shop")

public class ProductCont {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/home")
    public String showHomePage(@ModelAttribute("user") User user, Model model) {
        if (user == null) {
            return "redirect:/user/login";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("keyword", new SearchRequestDto());
            return "index";
        }
    }

    @PostMapping(path = "/search")
    public String searchProduct(@ModelAttribute("keyword") SearchRequestDto keyword, Model model) {
        List<Product> products = productService.search(keyword.getKeyword());
        model.addAttribute("products", products);
        return "Shop";
    }

    public class SearchRequestDto {
        private String keyword;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }
    }
}
