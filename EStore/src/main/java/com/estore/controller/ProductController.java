package com.estore.controller;

import com.estore.entity.ProductEntity;
import com.estore.entity.UserEntity;
import com.estore.service.ProductService;
import com.estore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> productEntities=new ArrayList<>();
        try {
            productEntities= productService.findAll();
        } catch (Exception e) {
            return new ResponseEntity<List<ProductEntity>>(productEntities,
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<List<ProductEntity>>(productEntities, HttpStatus.OK);
    }
}
