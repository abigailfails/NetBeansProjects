package com.github.abigailfails.orders;

import java.util.Currency;

public class Product {
    private String productId;
    private double productPrice; //in GBP

    public Product(String productId, double productPrice) {
        this.productId = productId;
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
