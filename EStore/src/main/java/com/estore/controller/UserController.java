package com.estore.controller;

import com.estore.entity.UserEntity;
import com.estore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> register(@RequestBody UserEntity userEntity) {
        boolean userAvailability=false;
        try {
            userAvailability= userService.save(userEntity);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(userAvailability,
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Boolean>(userAvailability, HttpStatus.OK);
    }
}
