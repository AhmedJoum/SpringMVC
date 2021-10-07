package com.example.demo.Product;

import com.example.demo.Utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

import com.example.demo.User.User;
import  org.springframework.util.*;


import java.nio.file.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/shop")

public class ProductCont {

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/add-product")
    public String addProduct(Model model) {
        Product product = new Product();

        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping(path = "/save-product")
    public String saveProduct(@ModelAttribute("product") Product product,
                              RedirectAttributes redir,
                              @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setImgPath(fileName);

        productService.Add(product);

        String uploadDir = "product-imgs/" + product.getProductId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
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
    public String searchProduct(@ModelAttribute("keyword") SearchRequestDto keyword,
                                HttpServletRequest request,
                                Model model) {
        var user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/user/login";
        } else {
            model.addAttribute("user", user);

            List<Product> products = productService.search(keyword.getKeyword());
            model.addAttribute("products", products);
            return "Shop";
        }
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
