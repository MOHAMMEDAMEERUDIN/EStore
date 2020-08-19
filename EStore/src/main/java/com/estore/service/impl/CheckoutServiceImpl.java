package com.estore.service.impl;

import com.estore.repository.CartRepository;
import com.estore.service.CartService;
import com.estore.service.CheckoutService;
import com.estore.service.EmailService;
import com.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "cartService")
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private EmailService emailService;

    @Override
    public void checkoutAndMail(String currentUser) {
        emailService.sendEmail(currentUser,"Hi, Thanks for the order.. Keep Shopping!!!","Acknowledgement for the Order");
    }
}
