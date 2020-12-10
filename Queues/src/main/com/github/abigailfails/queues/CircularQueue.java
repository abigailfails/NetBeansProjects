package main.com.github.abigailfails.queues;

public class CircularQueue<T> extends LinearQueue<T> {
    /**
     * @param queue must be empty
     */
    public CircularQueue(T[] queue) {
        super(queue);
    }

    @Override
    public void enQueue(T item) {
        rear++;
        size++;
        if(rear>=queue.length) rear = 0;
        //TODO then check for it 'overlapping' somehow, this needs to be prevented
        queue[rear] = item;
    }

    @Override
    public T deQueue() {
        return super.deQueue();
    }
}
