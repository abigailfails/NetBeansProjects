package com.github.abigailfails.orders;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private final int orderNumber;
    private final LocalDate orderDate;
    private ArrayList<Product> productsOrdered = new ArrayList<>();
    private int orderedItemCount;
    private OrderStatus orderStatus;

    public Order(int orderNumber, LocalDate orderDate) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderStatus = new OrderStatus();
    }

    public void orderItem(Product orderedItem) {
        productsOrdered.add(orderedItem);
        orderedItemCount++;
    }

    public String getOrderStatus() {
        return this.orderStatus.get();
    }

    public void setOrderStatus (boolean orderStatus) {
        this.orderStatus.set(orderStatus);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getOrderItemId(int index) {
        try {
            return this.productsOrdered.get(index).getProductId();
        }
        catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("Product at index " + index + " does not exist.");
        }
    }

    public double getOrderItemPrice(int index) {
        try {
            return this.productsOrdered.get(index).getProductPrice();
        }
        catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("No product at position " + index);
        }
    }

    public int getOrderedItemCount() {
        return orderedItemCount;
    }

    public double getTotalPrice() {
        return this.productsOrdered.stream().mapToDouble(Product::getProductPrice).sum();
    }
}
