package main.com.github.abigailfails.queues;

import java.util.Arrays;

public class LinearQueue<T> {
    protected final T[] queue;
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

    public void add(T item) {
        rear++;
        queue[rear] = item;
    }

    public T remove() {
        front++;
        return queue[front-1];
    }

    public T peek() {
        return queue[front];
    }

    public T[] get() {
        return queue.clone();
    }

    public boolean isFull() {
        return rear == queue.length-1;
    }

    public boolean isEmpty() {
        return rear+1 == front;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < queue.length-1; i++) {
            string.append(queue[i]).append(", ");
        }
        string.append(queue[queue.length-1]);
        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinearQueue) {
            return Arrays.equals(((LinearQueue<?>) obj).get(), this.get());
        }
        return false;
    }
}
