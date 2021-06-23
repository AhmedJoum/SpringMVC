package com.example.demo.OrderProducts;

import javax.persistence.*;

@Entity
@Table
public class OrderProducts {

    @Id
    @SequenceGenerator(name = "orderProductSequence", sequenceName = "orderProductSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderProductSequence")

    private long orderProductsId;
    private Long orderId;
    private Long productId;
    private int qty;

    // standard constructors

    public OrderProducts() {
    }

    public long getOrderProductsId() {
        return orderProductsId;
    }

    public void setOrderProductsId(long order_products_id) {
        this.orderProductsId = order_products_id;
    }

    public OrderProducts(Long orderId, Long productId, int qty) {
        this.orderId = orderId;
        this.productId = productId;
        this.qty = qty;
    }

    // standard getters and setters

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long order_id) {
        this.orderId = order_id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long product_id) {
        this.productId = product_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
      this.qty = qty;
    }
}
