package com.example.demo.Product;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.persistence.*;
import java.net.URL;
import java.util.List;
import com.example.demo.OrderProducts.OrderProducts;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )


    private Long product_id;
    private String product_name;
    private String description;
    private String img_path;
    private long price;
    private int in_stock_qty;
    @OneToMany
    @JoinColumn(name = "product_id")
    private List<OrderProducts> order_products;

    // standard constructors

    public Product() {
    }

    public List<OrderProducts> getOrder_products() {
        return order_products;
    }

    public void setOrder_products(List<OrderProducts> order_products) {
        this.order_products = order_products;
    }

    public Product(Long product_id, String product_name, String description, String imgPath, long price, int inStockQty) {
        this.product_id = product_id;
        product_name = product_name;
        description = description;
        img_path = imgPath;
        this.price = price;
        in_stock_qty = inStockQty;
    }

    public Product(String product_name, String description, String imgPath, long price, int inStockQty) {
        product_name = product_name;
        description = description;
        img_path = imgPath;
        this.price = price;
        in_stock_qty = inStockQty;
    }

    // standard getters and setters


    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public String getImgPath() {
        return img_path;
    }

    public void setImgPath(String imgPath) {
        img_path = imgPath;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getInStockQty() {
        return in_stock_qty;
    }

    public void setInStockQty(int inStockQty) {
        in_stock_qty = inStockQty;
    }
}

