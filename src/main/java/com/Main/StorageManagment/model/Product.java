package com.Main.StorageManagment.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private String category;
    private String productImage;
    private String productStatus;

    public Product(String productName, String productDescription, Long productPrice, String category, String productImage, String productStatus) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.category = category;
        this.productImage = productImage;
        this.productStatus = productStatus;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", category='" + category + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productStatus='" + productStatus + '\'' +
                '}';
    }
}
