package com.example.demo.productImgs;

import javax.persistence.Entity;
import javax.persistence.Table;


import javax.persistence.*;

@Entity
@Table
public class ProductImgs {
    @Id
    @SequenceGenerator(name = "productImgSequence", sequenceName = "productImgSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productImgSequence")
    private long productImgId;
    private Long productId;
    private String ImgPath;

    
    public long getProductImgId() {
        return productImgId;
    }
    public String getImgPath() {
        return ImgPath;
    }
    public void setImgPath(String imgPath) {
        this.ImgPath = imgPath;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public void setProductImgId(long productImgId) {
        this.productImgId = productImgId;
    }
    
}
