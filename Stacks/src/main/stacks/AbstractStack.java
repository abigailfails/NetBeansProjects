package main.stacks;

public abstract class AbstractStack<T> {

    public abstract void push(T item);

    public abstract T pop();

    public abstract T peek();

    public abstract boolean isEmpty();

    public abstract boolean isFull();

    public abstract int size();

    public abstract T[] getValues();
}
