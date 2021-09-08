package com.example.demo.ProductImgs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImgsService {
    @Autowired
    private ProductImgRep imgRep;

    public void Add(ProductImgs img) {
        imgRep.save(img);
    }

    public List<ProductImgs> getByProductId(Long productId) {
        var imgs = imgRep.getByProductId(productId);
        return imgs;
    }
}
