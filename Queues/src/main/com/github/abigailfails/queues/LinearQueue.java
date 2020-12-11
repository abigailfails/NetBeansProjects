package main.com.github.abigailfails.queues;

import java.util.Arrays;

public class LinearQueue<T> {
    protected final T[] queue;
    protected int size = 0;
    protected int front;
    protected int rear;

    /**
     * @param queue must be empty
     * */
    public LinearQueue(T[] queue) {
        Arrays.fill(queue, null);
        this.queue = queue;
        this.front = 0;
        this.rear = -1;
    }

    public void enQueue(T item) {
        rear++;
        size++;
        queue[rear] = item;
    }

    public T deQueue() {
        front++;
        size--;
        return queue[front-1];
    }

    public T peek() {
        return queue[front];
    }

    public boolean isFull() {
        return rear == queue.length-1;
    }

    public boolean isEmpty() {
        return rear+1 == front;
    }
}
