package com.example.demo.OrderProducts;

import javax.persistence.*;

@Entity
@Table
public class OrderProducts {

    @Id
    @SequenceGenerator(
            name = "orderProduct_sequence",
            sequenceName = "orderProduct_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderProduct_sequence"
    )

    private Long orderProduct_id;
    private String order_id;
    private String product_id;
    private int Qty;


    // standard constructors

    public OrderProducts() {
    }

    public OrderProducts(Long orderProduct_id, String order_id, String product_id, int qty) {
        this.orderProduct_id = orderProduct_id;
        this.order_id = order_id;
        this.product_id = product_id;
        Qty = qty;
    }

    public OrderProducts(String order_id, String product_id, int qty) {
        this.order_id = order_id;
        this.product_id = product_id;
        Qty = qty;
    }

    // standard getters and setters


    public Long getOrderProduct_id() {
        return orderProduct_id;
    }

    public void setOrderProduct_id(Long orderProduct_id) {
        this.orderProduct_id = orderProduct_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }
}

