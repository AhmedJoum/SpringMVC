package com.example.demo.OrderHdr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHdrService {

    @Autowired
    private OrderHdrRep orderHdrRep;

    public List<OrderHdr> getOrder() { return orderHdrRep.findAll(); }
}