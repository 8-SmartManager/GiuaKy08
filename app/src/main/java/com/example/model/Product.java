package com.example.model;

public class Product {
    private int productId;
    private int productImage;
    private String productName;
    private String productDes;


    public Product(int productId, int productImage, String productName, String productDes) {
        this.productId = productId;
        this.productImage = productImage;
        this.productName = productName;
        this.productDes = productDes;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
