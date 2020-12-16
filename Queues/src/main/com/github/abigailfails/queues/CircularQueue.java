package main.com.github.abigailfails.queues;

public class CircularQueue<T> extends LinearQueue<T> {
    protected int size = 0;

    /**
     * @param queue must be empty
     */
    public CircularQueue(T[] queue) {
        super(queue);
    }

    @Override
    public void add(T item) {
        if(!isFull()) {
            size++;
            rear = (rear+1) % queue.length;
            queue[rear] = item;
        }
    }

    @Override
    public T remove() {
        if(!isEmpty()) {
            int oldFront = front;
            front = (front+1) % queue.length;
            size--;
            return queue[oldFront];
        }
        return null;
    }

    //TODO pointer solution
    @Override
    public boolean isFull() {
        return size == queue.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
