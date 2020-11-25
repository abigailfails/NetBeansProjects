package com.github.abigailfails.orders;

public class OrderStatus {
    private boolean hasShipped;

    public OrderStatus() {
        this.hasShipped = false;
    }

    public OrderStatus(boolean hasShipped) {
        this.hasShipped = hasShipped;
    }

    public void set(boolean hasShipped) {
        this.hasShipped = hasShipped;
    }

    public String get() {
        return this.hasShipped ? "Shipped" : "Not Shipped";
    }

}
