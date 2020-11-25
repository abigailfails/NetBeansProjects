package com.github.abigailfails.orders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Product product1 = new Product("beans", 0.45);
        Product product2 = new Product("eggs", 1.25);
        Order myOrder = new Order(1, LocalDate.parse("01/01/17", DateTimeFormatter.ofPattern("dd/MM/yy")));
        myOrder.orderItem(product1);
        myOrder.orderItem(product2);
        System.out.println(myOrder.getOrderStatus());
        System.out.println(myOrder.getOrderItemId(0));
        System.out.println(myOrder.getOrderItemPrice(0));
        System.out.println(myOrder.getOrderItemId(1));
        System.out.println(myOrder.getOrderItemPrice(1));
        System.out.println(myOrder.getOrderedItemCount());
        /*Product product3 = new Product("toast", 1.01);
        myOrder.orderItem(product3);
        System.out.println("(Toast ordered)");
        System.out.println(myOrder.getOrderedItemCount());
        System.out.println("Your bill is £"+myOrder.getTotalPrice()+".");*/
    }
}
