package com.estore.service;

import com.estore.entity.ProductEntity;
import com.estore.entity.UserEntity;

import java.util.List;

public interface ProductService {

    void saveAll(List<ProductEntity> productEntities);
    List<ProductEntity> findAll();
    ProductEntity findByPk(String productId);
    void saveProducts();
}
