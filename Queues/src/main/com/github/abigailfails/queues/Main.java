package main.com.github.abigailfails.queues;

public class Main {

    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(new Integer[10]);
        for (int i = 0; i < 10; i++) {
            circularQueue.enQueue(i);
        }
        circularQueue.enQueue(5);
        System.out.println(circularQueue.deQueue());
        circularQueue.enQueue(5);
        for(int i = 0; i < 11; i++) {
            System.out.println(circularQueue.deQueue());
        }
    }
}
