package com.github.abigailfails.queue;

/**
 * @author water, flowers
 */
public class PriorityElement<T> {
    private final T value;
    private final double priority;
    private PriorityElement<T> previous;
    private PriorityElement<T> next;

    public PriorityElement(T value, double priority, PriorityElement<T> previous, PriorityElement<T> next) {
        this.value = value;
        this.priority = priority;
        this.previous = previous;
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public T getValue() {
        return value;
    }

    public double getPriority() {
        return priority;
    }

    public PriorityElement<T> getPrevious() {
        return previous;
    }

    public void setPrevious(PriorityElement<T> value) {
        previous = value;
    }

    public PriorityElement<T> getNext() {
        return next;
    }

    public void setNext(PriorityElement<T> value) {
        next = value;
    }

    /**
     * Allows comparison with an inputted value without having to create a new element object
     */
    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof PriorityElement) {
            PriorityElement element = (PriorityElement) obj;
            return this.getValue().equals(element.getValue()) && this.getPriority() == element.getPriority();
        }
        return this.getValue().equals(obj);
    }
}