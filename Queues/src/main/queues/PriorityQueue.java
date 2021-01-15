package main.queues;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> {
    protected ArrayList<PriorityItem<T>> queue;
    protected int size;
    protected int maxSize;

    public PriorityQueue() {
        this(0);
    }

    public PriorityQueue(int maxSize) {
        this.queue = new ArrayList<>();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public void add(T item, int priority) {
        if(!isFull()) {
            int index;
            for (int i = 0; i < queue.size(); i++) {
                if(queue.get(i).getPriority()==priority+1) {
                    index = i;
                    queue.add(index, new PriorityItem<>(item, priority));
                    return;
                }
            }
            queue.add(new PriorityItem<>(item, priority));
            size++;
        }
    }

    public T remove() {
        if(!isEmpty()) {
            return queue.remove(0).getItem();
        }
        return null;
    }

    public T peek() {
        return queue.get(0).getItem();
    }

    public ArrayList<PriorityItem<T>> get() {
        return (ArrayList<PriorityItem<T>>) queue.clone();
    }

    public ArrayList<T> values() {
        ArrayList<T> values = new ArrayList<>();
        for (PriorityItem<T> item : queue) {
            values.add(item.getItem());
        }
        return values;
    }

    public ArrayList<Integer> priorities() {
        ArrayList<Integer> priorities = new ArrayList<>();
        for (PriorityItem<T> item : queue) {
            priorities.add(item.getPriority());
        }
        return priorities;
    }

    public boolean isFull() {
        return maxSize > 0 && size == maxSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < queue.size()-1; i++) {
            string.append(queue.get(i)).append(", ");
        }
        string.append(queue.get(queue.size()-1));
        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PriorityQueue) {
            return this.get().equals(((PriorityQueue<?>) obj).get());
        }
        return false;
    }
}
