package com.estore.entity;

import com.estore.entity.common.KeyEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CART", schema = "estore")
public class CartEntity extends KeyEntity implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "QTY")
    private int qty;


    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "productEntity=" + productEntity +
                ", email='" + email + '\'' +
                ", qty=" + qty +
                '}';
    }
}
