package com.estore.repository;

import com.estore.entity.ProductEntity;
import com.estore.entity.UserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier(value = "productRepository")
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByOrderByPriceAsc();

    ProductEntity findByPk(String pk);

    ProductEntity findByProductId(Long pId);


}
