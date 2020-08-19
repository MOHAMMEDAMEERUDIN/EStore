package com.estore.repository;

import com.estore.entity.CartEntity;
import com.estore.entity.ProductEntity;
import com.estore.entity.UserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier(value = "cartRepository")
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findByProductEntityAndEmail(ProductEntity productEntity, String currentUser);

    List<CartEntity> findByEmail(String currentUser);

    long deleteByEmail(String currentUser);
}
