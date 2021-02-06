package linkedqueue;

import java.util.ArrayList;

/**
 * A priority queue implemented as a linked queue.
 *
 * @param <T> the type of data stored in the queue
 *
 * @author water, flowers
 */
public class PriorityQueue<T> {
    private PriorityElement<T> front; //The front of the queue, e.g the 1st element
    private int length = 0;

    /**
     * Converts the queue into an array of {@code T}.
     *
     * @return the queue as a {@code T[]} array
     * */
    @SuppressWarnings("unchecked")
    public T[] asArray() {
        ArrayList<T> a = new ArrayList<>();
        PriorityElement<T> e = front;
        
        while (e != null) {
            //Iterate through elements adding to the array
            a.add(e.getValue());
            e = e.getNext();
        }
        
        return (T[]) a.toArray(new Object[0]);
    }

    /**
     * Returns whether the queue is empty, meaning it has no stored elements.
     *
     * @return {@code true} if the queue has no elements
     * */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * Adds an inputted {@code value} to the end of the queue.
     * 
     * @param value the element to append
     * */
    public void add(T value, int priority) {
        PriorityElement<T> current;

        if (front != null) {
            current = front;// Start at the front of the PriorityQueue

            while (current.getPriority() < priority && current.getNext() != null) {
                //Iterate through elements in the PriorityQueue
                current = current.getNext();
            }
            appendElement(value, priority, priority < current.getPriority(), current);
        }
        else {
            //Add the front of the linked queue
            front = new PriorityElement<>(value, priority, null, null);
            length++;
        }
    }

    /**
     * Removes the first element that matches {@code value} and reorganises the queue.
     * 
     * @param value the element to remove from the queue
     *
     * @throws IllegalArgumentException if the element does not exist
     * @return the element that was removed
     * */
    public T remove(T value) {
        PriorityElement<T> e = front;
        while (e != null) {
            if (e.equals(value)) {
                return removeElement(e);
            }
            e = e.getNext();
        }
        throw new IllegalArgumentException("Cannot remove element " + value + " as it does not exist in the queue.");
    }

    /**
     * Removes the 1st element from the queue and reorganises the queue.
     * 
     * @return the element that was removed
     * */
    public T pop() {
        PriorityElement<T> oldFront = front;
        if (oldFront == null) throw new UnsupportedOperationException("Cannot remove element from an empty queue.");
        removeElement(front);
        return oldFront.getValue();
    }

    private T removeElement(PriorityElement<T> e) {
        PriorityElement<T> previous = e.getPrevious();
        PriorityElement<T> next = e.getNext();
        if (previous != null) {
            previous.setNext(next);
        } else front = next;
        if (next != null) {
            next.setPrevious(previous);
        }
        length--;
        return e.getValue();
    }

    //If shouldShiftRight is false, adds the new element after elementToShift instead of before
    private void appendElement(T value, int priority, boolean shouldShiftRight, PriorityElement<T> elementToShift) {
        PriorityElement<T> previous = shouldShiftRight ? elementToShift.getPrevious() : elementToShift;
        PriorityElement<T> next = shouldShiftRight  ? elementToShift : elementToShift.getNext();
        PriorityElement<T> newElement = new PriorityElement<>(value, priority, previous, next);
        if (next != null) {
            next.setPrevious(newElement);
        }
        if (previous != null) {
            previous.setNext(newElement);
        } else front = newElement;
        if (shouldShiftRight) elementToShift.setPrevious(newElement);
        length++;
    }

    /**
     * Returns the number of times {@code value} appears in the queue.
     *
     * @param value the value to look for in the queue
     *
     * @return the number of elements matching {@code value} in the queue, or 0 if there are none
     * */
    public int count(T value) {
        PriorityElement<T> e = front;
        int count = 0;
        while(e != null) {
            if (e.equals(value)) count++;
            e = e.getNext();
        }
        return count;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     * */
    public int length() {
        return length;
    }
}