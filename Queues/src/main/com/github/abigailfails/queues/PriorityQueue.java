package main.com.github.abigailfails.queues;

import java.util.ArrayList;

public class PriorityQueue<T> {
    protected ArrayList<PriorityItem<T>> queue;
    protected int size = 0;
    protected int maxSize;

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
        }
    }

    public T remove() {
        if(!isEmpty()) {
            return queue.remove(queue.size()-1).getItem();
        }
        return null;
    }

    public T peek() {
        return queue.get(queue.size()-1).getItem();
    }

    public ArrayList<PriorityItem<T>> get() {
        //cast needed, apparently
        return (ArrayList<PriorityItem<T>>) queue.clone();
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
