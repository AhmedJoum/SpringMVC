package com.example.demo.OrderProducts;

import javax.persistence.*;

@Entity
@Table
public class OrderProducts {

    @Id
    @SequenceGenerator(name = "orderProduct_sequence", sequenceName = "orderProduct_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderProduct_sequence")

    private long order_products_id;
    private Long order_id;
    private Long product_id;
    private int Qty;

    // standard constructors

    public OrderProducts() {
    }

    public long getOrder_products_id() {
        return order_products_id;
    }

    public void setOrder_products_id(long order_products_id) {
        this.order_products_id = order_products_id;
    }

    public OrderProducts(Long order_id, Long product_id, int qty) {
        this.order_id = order_id;
        this.product_id = product_id;
        Qty = qty;
    }

    // standard getters and setters

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }
}
