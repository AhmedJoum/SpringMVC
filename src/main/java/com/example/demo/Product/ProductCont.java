package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import com.example.demo.User.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/shop")

public class ProductCont {

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/add-product")
    public String addProduct(Model model)
    {
        Product product = new Product();
       
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping(path = "/save-product")
    public String saveProduct(@ModelAttribute("product") Product product,
     RedirectAttributes redir)
    {
        productService.Add(product);
        return "redirect:/shop/home";
    }

    @GetMapping(path = "/home")
    public String showHomePage(HttpServletRequest request, Model model) {
        var user = (User) request.getSession().getAttribute("user");
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
