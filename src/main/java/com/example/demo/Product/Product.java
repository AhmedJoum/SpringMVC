package com.example.demo.Product;

import javax.persistence.*;
import java.util.List;
import com.example.demo.OrderProducts.OrderProducts;
import com.example.demo.ProductImgs.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "productSequence",
            sequenceName = "productSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "productSequence"
    )


    private Long productId;
    private String productName;
    private String description;
    private String imgPath;
    private long price;
    private int inStockQty;
    @OneToMany
    @JoinColumn(name = "productId")
    private List<OrderProducts> orderProducts;

    @OneToMany
    @JoinColumn(name = "productId")
    private List<ProductImgs> productImgs;

    

    public Product() {
    }

    public List<ProductImgs> getProductImgs() {
        return productImgs;
    }

    public void setProductImgs(List<ProductImgs> productImgs) {
        this.productImgs = productImgs;
    }

    public List<OrderProducts> getOrder_products() {
        return orderProducts;
    }

    public void setOrder_products(List<OrderProducts> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Product(Long productId, String productName, String description, String imgPath, long price, int inStockQty) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.imgPath = imgPath;
        this.price = price;
        this.inStockQty = inStockQty;
    }

    public Product(String product_name, String description, String imgPath, long price, int inStockQty) {
        this.productName = product_name;
        this.description = description;
        this.imgPath = imgPath;
        this.price = price;
        this.inStockQty = inStockQty;
    }

    // standard getters and setters


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long value) {
        this.productId = value;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String value) {
        this.productName = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String value) {
        this.imgPath = value;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long value) {
        this.price = value;
    }

    public int getInStockQty() {
        return inStockQty;
    }

    public void setInStockQty(int value) {
       this.inStockQty = value;
    }
}

