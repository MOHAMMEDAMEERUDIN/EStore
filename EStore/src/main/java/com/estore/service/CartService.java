package com.estore.service;

import com.estore.entity.CartEntity;
import com.estore.entity.ProductEntity;
import com.estore.entity.UserEntity;

import java.util.List;

public interface CartService {

    boolean addToCart(String prodId, String currentUser);

    List<ProductEntity> getAllCartItems(String currentUser);

    boolean removeAllCartItems(String currentUser);

    void removeSelectedItemFromCart(String currentUser, String prodId);
}
