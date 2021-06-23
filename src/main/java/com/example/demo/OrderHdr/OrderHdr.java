package com.example.demo.OrderHdr;

import java.util.List;

import javax.persistence.*;
import com.example.demo.OrderProducts.OrderProducts;

@Entity
@Table
public class OrderHdr {

    @Id
    @SequenceGenerator(name = "orderSequence", sequenceName = "orderSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSequence")

    private Long orderId;
    private Long userId;
    private OrderStatus status;
    private long totalPrice;

    @OneToMany
    @JoinColumn(name = "orderId")
    private List<OrderProducts> orderProducts;

    // standard constructors

    public OrderHdr() {
    }

    public OrderHdr(Long orderId, long userId, OrderStatus status, long totalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public OrderHdr(long userId, OrderStatus status, long totalPrice) {
        this.userId = userId;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    // standard getters and setters

    public List<OrderProducts> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProducts> value) {
        orderProducts = value;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long value) {
        this.orderId = value;
    }

    public Long getUser_id() {
        return userId;
    }

    public void setUserId(Long value) {
        this.userId = value;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long value) {
        this.totalPrice = value;
    }

}
