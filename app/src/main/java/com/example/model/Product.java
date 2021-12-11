package com.example.model;

public class Product {
    private int productId;
    private String productName;
    private String productDes;
    private int productImage;

    public Product(int productId, String productName, String productDes, int productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productDes = productDes;
        this.productImage = productImage;
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
