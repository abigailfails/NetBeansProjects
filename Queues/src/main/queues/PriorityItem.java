package main.queues;

public class PriorityItem<T> {
    protected T item;
    protected int priority;

    public PriorityItem (T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    public T getItem() {
        return item;
    }

    public int getPriority() {
        return priority;
    }
}
