package com.estore.service.impl;

import com.estore.entity.CartEntity;
import com.estore.entity.ProductEntity;
import com.estore.repository.CartRepository;
import com.estore.service.CartService;
import com.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier(value = "cartService")
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;



    @Override
    public boolean addToCart(String prodId, String currentUser) {
        try {
            ProductEntity productEntity = productService.findByPk(prodId);
            CartEntity cartEntity = cartRepository.findByProductEntityAndEmail(productEntity, currentUser);

            if (cartEntity == null) {
                cartEntity = new CartEntity();

                cartEntity.setProductEntity(productEntity);
                cartEntity.setEmail(currentUser);
            }

            cartEntity.setQty(cartEntity.getQty() + 1);
            cartRepository.save(cartEntity);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<ProductEntity> getAllCartItems(String currentUser) {
        List<CartEntity> cartEntities = cartRepository.findByEmail(currentUser);
        List<ProductEntity> productEntities=new ArrayList<>();
        for(CartEntity cartEntity:cartEntities) {
            if(cartEntity.getQty()>=1) {
                for (int i = 0; i < cartEntity.getQty(); i++) {
                    productEntities.add(cartEntity.getProductEntity());
                }
            }
        }
        return productEntities;

    }

    @Override
    public boolean removeAllCartItems(String currentUser) {
        try{
            List<CartEntity> cartEntities = cartRepository.findByEmail(currentUser);
            for(CartEntity cartEntity:cartEntities) {
                cartEntity.setQty(0);
                cartRepository.save(cartEntity);
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeSelectedItemFromCart(String currentUser, String prodId) {
        ProductEntity productEntity = productService.findByPk(prodId);
        CartEntity cartEntity = cartRepository.findByProductEntityAndEmail(productEntity, currentUser);

        if(cartEntity!=null && cartEntity.getQty()>=1){
            cartEntity.setQty(cartEntity.getQty()-1);
            cartRepository.save(cartEntity);
        }

    }
}
