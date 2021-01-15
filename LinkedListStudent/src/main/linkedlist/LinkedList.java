package linkedlist;

import java.util.ArrayList;

/**
 * A linked list implementation, with methods for removing from the front and adding to the back.
 *
 * @param <T> the type of data stored in the list
 *
 * @author water, flowers
 */
public class LinkedList<T> {
    private Element<T> front; //The front of the list, e.g the 1st element
    private int length = 0;

    /**
     * Converts the list into an array of {@code T}.
     *
     * @return the list as a {@code T[]} array
     * */
    @SuppressWarnings("unchecked")
    public T[] asArray() {
        ArrayList<T> a = new ArrayList<>();
        Element<T> e = front;
        
        while (e != null) {
            //Iterate through elements adding to the array
            a.add(e.getValue());
            e = e.getNext();
        }
        
        return (T[]) a.toArray(new Object[0]);
    }

    /**
     * Returns whether the list is empty, meaning it has no stored elements.
     *
     * @return {@code true} if the list has no elements
     * */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * Appends an inputted {@code value} to the end of the list.
     * 
     * @param value the element to append
     * */
    public void append(T value) {
        Element<T> current;
        Element<T> tail;
        
        if (front != null) {
            current = front;// Start at the front of the LinkedList
            
            while (current.getNext() != null) {
                //Iterate through elements in the LinkedList
                current = current.getNext();
            }
            
            tail = new Element<T>(value, current, null);// Create new tail Element pointing back to the previous Tail
            current.setNext(tail);//Update the end of the LinkedList to point to this new Element
        }
        else {
            //Add the front of the linked list
            front = new Element<>(value, null, null);
        }
        length++;
    }

    /**
     * Removes the first element that matches {@code value} and reorganises the list.
     * 
     * @param value the element to remove from the list
     *
     * @throws IllegalArgumentException if the element does not exist
     * @return the element that was removed
     * */
    public T remove(T value) {
        Element<T> e = front;
        while (e != null) {
            if (e.equals(value)) {
                return removeElement(e);
            }
            e = e.getNext();
        }
        throw new IllegalArgumentException("Cannot remove element " + value + " as it does not exist in the list.");
    }

    /**
     * Removes the 1st element from the list and reorganises the list.
     * 
     * @return the element that was removed
     * */
    public T pop() {
        Element<T> oldFront = front;
        if (oldFront == null) throw new UnsupportedOperationException("Cannot remove element from an empty list.");
        removeElement(front);
        return oldFront.getValue();
    }

    /**
     * Removes the element at {@code index} from the list and reorganises the list.
     *
     * @param index the position to remove the element from
     *
     * @throws IndexOutOfBoundsException if there is no element at {@code index}
     * @return the element that was removed
     * */
    public T pop(int index) {
        Element<T> e = front;
        for (int i=0; i<index; i++) {
            if (e == null) break;
            e = e.getNext();
        }
        if (e != null) {
            return removeElement(e);
        } else throw new IndexOutOfBoundsException("Cannot pop from position " + index + " as no element exists there.");
    }

    private T removeElement(Element<T> e) {
        Element<T> previous = e.getPrevious();
        Element<T> next = e.getNext();
        if (previous != null) {
            previous.setNext(next);
        } else front = next;
        if (next != null) {
            next.setPrevious(previous);
        }
        length--;
        return e.getValue();
    }

    private void addElement(T value, Element<T> elementToShift) {
        Element<T> previous = elementToShift.getPrevious();
        Element<T> newElement = new Element<T>(value, previous, elementToShift);
        if (previous != null) {
            previous.setNext(newElement);
        } else front = newElement;
        elementToShift.setPrevious(newElement);
        length++;
    }

    /**
     * Inserts {@code value} at the position specified by {@code index}, shifting the element previously at that position
     * and all subsequent elements back by 1.
     *
     * @param value the element to insert
     * @param index the position to insert {@code value} at
     *
     * @throws IndexOutOfBoundsException if the position at {@code index} is not in the list
     * */
    public void insert(T value, int index) {
        if (index < 0 || index >= this.length())
            throw new IndexOutOfBoundsException("Cannot insert at position " + index + ", as it is not found in the list.");
        Element<T> e = front;
        for (int i=0; i<index; i++) {
            e = e.getNext();
        }
        addElement(value, e);
    }

    /**
     * Returns the position of {@code value} in the list, or -1 if no such element exists.
     *
     * @param value the value to look for in the list
     *
     * @return the index of {@code value}, or -1 if it is not in the list
     * */
    public int index(T value) {
        Element<T> e = front;
        int i = 0;
        while(e != null) {
            if (e.equals(value)) return i;
            e = e.getNext();
            i++;
        }
        return -1;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     * */
    public int length() {
        return length;
    }

    /**
     * Returns whether {@code value} exists in the list.
     *
     * @param value the value to search for
     *
     * @return {@code true} if {@code value} is found in the list
     * */
    public boolean search(T value) {
        return index(value) >= 0;
    }
}