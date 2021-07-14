package com.github.abigailfails.queue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        System.out.println("Initialising linked priority queue...");
        System.out.println("Queue: " + Arrays.toString(queue.values()));
        queue.add(3, 2);
        System.out.println("Added 3 with priority 2.");
        System.out.println("Queue: " + Arrays.toString(queue.values()));
        queue.add(5, 1);
        System.out.println("Added 5 with priority 1");
        System.out.println("Queue: " + Arrays.toString(queue.values()));
        queue.add(3, 1);
        System.out.println("Added 3 with priority 1");
        System.out.println("Queue: " + Arrays.toString(queue.values()));
        System.out.println("Is the queue empty? " + queue.isEmpty());
        System.out.println("Popped the first element (" + queue.pop() + ") from the queue.");
        System.out.println("Queue: " + Arrays.toString(queue.values()));
        System.out.println("Does the queue contain 7? " + (queue.count(7)>0));
        queue.add(7, 6);
        System.out.println("Added 7 with priority 6");
        System.out.println("Queue: " + Arrays.toString(queue.values()));
        System.out.println("How many 7s are in the queue? " + queue.count(7));
        queue.pop();
        System.out.println("Popped the first element from the queue.");
        System.out.println("Queue: " + Arrays.toString(queue.values()));
        queue.remove(3);
        System.out.println("Removed the first element of value 3 from the queue.");
        System.out.println("Queue: " + Arrays.toString(queue.values()));
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}