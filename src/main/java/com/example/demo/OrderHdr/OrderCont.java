package com.example.demo.OrderHdr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/order")
public class OrderCont {

    @Autowired
    private OrderHdrService orderHdrService;


    @GetMapping("/")
    public String getOrder() {
        List<OrderHdr> x = orderHdrService.getOrder();
        return  "login";
    }
    }


