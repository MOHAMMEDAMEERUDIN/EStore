package com.estore.service;

import com.estore.entity.ProductEntity;

import java.util.List;

public interface CheckoutService {

    void checkoutAndMail(String currentUser);
}
