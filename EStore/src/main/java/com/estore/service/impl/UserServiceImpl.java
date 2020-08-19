package com.estore.service.impl;

import com.estore.entity.UserEntity;
import com.estore.repository.UserRepository;
import com.estore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean save(UserEntity userEntity) {
        UserEntity existingUserEntity = userRepository.findByEmail(userEntity.getEmail());
        if(existingUserEntity ==null){
            userRepository.save(userEntity);
            return true;
        } else {
            return false;
        }
    }


}
