package com.estore.controller;

import com.estore.entity.ProductEntity;
import com.estore.service.CartService;
import com.estore.service.ProductService;
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
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @RequestMapping(value = "/add/{currentUser}/{prodId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> addToCart(@PathVariable("currentUser") String currentUser,@PathVariable("prodId") String prodId) {
        boolean addedtocart=false;
        try {
            addedtocart= cartService.addToCart(prodId,currentUser);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(addedtocart,
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Boolean>(addedtocart, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllCartItems/{currentUser}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ProductEntity>> addToCart(@PathVariable("currentUser") String currentUser) {
        List<ProductEntity> productEntities=new ArrayList<>();
        try {
            productEntities= cartService.getAllCartItems(currentUser);
        } catch (Exception e) {
            return new ResponseEntity<List<ProductEntity>>(productEntities,
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<List<ProductEntity>>(productEntities, HttpStatus.OK);
    }

    @RequestMapping(value = "/removeAllCartItems/{currentUser}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> removeAllFromCart(@PathVariable("currentUser") String currentUser) {
        Boolean removed=false;
        try {
            removed= cartService.removeAllCartItems(currentUser);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(removed,
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Boolean>(removed, HttpStatus.OK);
    }

    @RequestMapping(value = "/removeSelectedItem/{currentUser}/{prodId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ProductEntity>> removeSelectedItem(@PathVariable("currentUser") String currentUser,@PathVariable("prodId") String prodId) {
        List<ProductEntity> productEntities=new ArrayList<>();
        try {
            cartService.removeSelectedItemFromCart(currentUser,prodId);
            productEntities= cartService.getAllCartItems(currentUser);
        } catch (Exception e) {
            return new ResponseEntity<List<ProductEntity>>(productEntities,
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<List<ProductEntity>>(productEntities, HttpStatus.OK);
    }
}
