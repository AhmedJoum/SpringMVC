package com.example.demo.OrderHdr;

import java.util.List;

import javax.persistence.*;

import com.example.demo.User.User;
import com.example.demo.OrderProducts.OrderProducts;

@Entity
@Table
public class OrderHdr {

    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")

    private Long order_id;
    private Long user_id;
    private String status;
    private long total_price;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderProducts> order_products;

    // standard constructors

    public OrderHdr() {
    }

    public OrderHdr(Long order_id, long user_id, String status, long total_price) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
    }

    public OrderHdr(long user_id, String status, long total_price) {
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
    }

    // standard getters and setters

    public List<OrderProducts> getOrder_products() {
        return order_products;
    }

    public void setOrder_products(List<OrderProducts> value) {
        order_products = value;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }

}
