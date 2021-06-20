package com.example.demo.OrderHdr;

import javax.persistence.*;

@Entity
@Table
public class OrderHdr {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    private Long order_id;
    private String user_id;
    private String status;
    private long total_price;


    // standard constructors

    public OrderHdr() {
    }

    public OrderHdr(Long order_id, String user_id, String status, long total_price) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
    }

    public OrderHdr(String user_id, String status, long total_price) {
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
    }

    // standard getters and setters


    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
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

