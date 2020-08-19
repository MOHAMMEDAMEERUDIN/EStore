package com.estore.service.impl;

import com.estore.entity.ProductEntity;
import com.estore.repository.ProductRepository;
import com.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Value("${estore.product.list}")
    private String productList;

    @Override
    public void saveAll(List<ProductEntity> productEntities) {
        productRepository.saveAll(productEntities);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public ProductEntity findByPk(String productId) {
        return productRepository.findByPk(productId);
    }

    @Override
    public void saveProducts() {

        String[] products = productList.split(";");
        for (String product : products) {
            ProductEntity productEntity = new ProductEntity();
            String[] pInfo=product.split(",");
            Long pId=Long. parseLong(pInfo[0].trim());
            String pName=pInfo[1].trim();
            Double pPrice=Double.parseDouble(pInfo[2].trim());
            ProductEntity existingProduct = productRepository.findByProductId(pId);
            if (existingProduct == null) {
                productEntity.setProductId(pId);
                productEntity.setProductName(pName);
                productEntity.setPrice(pPrice);
                productRepository.save(productEntity);
            }

        }


    }
}
