package com.estore.controller;

import com.estore.entity.ProductEntity;
import com.estore.service.CartService;
import com.estore.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/checkout")
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CheckoutService checkoutService;

    @RequestMapping(value = "/proceed/{currentUser}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> checkout(@PathVariable("currentUser") String currentUser) {
        boolean status=false;
        try {
            checkoutService.checkoutAndMail(currentUser);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(status,
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Boolean>(status, HttpStatus.OK);
    }

}
