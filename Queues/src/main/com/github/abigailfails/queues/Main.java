package main.com.github.abigailfails.queues;

public class Main {

    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(new Integer[10]);
        for (int i = 0; i < 10; i++) {
            circularQueue.add(i);
        }
        circularQueue.add(5);
        System.out.println(circularQueue.remove());
        circularQueue.add(5);
        for(int i = 0; i < 10; i++) {
            System.out.println(circularQueue.remove());
        }
        PriorityQueue<String> queue = new PriorityQueue<>();
    }
}
