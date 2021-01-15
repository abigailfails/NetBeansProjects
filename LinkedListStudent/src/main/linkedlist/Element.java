package linkedlist;

/**
 * @author water
 */
public class Element<T> {
    private final T value;
    private Element<T> previous;
    private Element<T> next;

    public Element(T value, Element<T> previous, Element<T> next) {
        this.value = value;
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

    public Element<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Element<T> value) {
        previous = value;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> value) {
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
        } else if (obj instanceof Element) {
            return this.getValue().equals((((Element) obj).getValue()));
        }
        return this.getValue().equals(obj);
    }
}