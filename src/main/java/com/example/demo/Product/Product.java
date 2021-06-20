package com.example.demo.Product;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.persistence.*;
import java.net.URL;

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
    private String Product_name;
    private String Description;
    private URL ImgPath;
    private long price;
    private int InStockQty;


    // standard constructors

    public Product() {
    }

    public Product(Long product_id, String product_name, String description, URL imgPath, long price, int inStockQty) {
        this.product_id = product_id;
        Product_name = product_name;
        Description = description;
        ImgPath = imgPath;
        this.price = price;
        InStockQty = inStockQty;
    }

    public Product(String product_name, String description, URL imgPath, long price, int inStockQty) {
        Product_name = product_name;
        Description = description;
        ImgPath = imgPath;
        this.price = price;
        InStockQty = inStockQty;
    }

    // standard getters and setters


    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public URL getImgPath() {
        return ImgPath;
    }

    public void setImgPath(URL imgPath) {
        ImgPath = imgPath;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getInStockQty() {
        return InStockQty;
    }

    public void setInStockQty(int inStockQty) {
        InStockQty = inStockQty;
    }
}

