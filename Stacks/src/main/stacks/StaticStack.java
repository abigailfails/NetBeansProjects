package main.stacks;

public class StaticStack<T> extends AbstractStack<T> {
    private final T[] stack;
    private int front = -1;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxSize) {
        stack = (T[]) new Object[maxSize];
    }

    @Override
    public void push(T item) {
        if (this.isFull())
            throw new IllegalArgumentException("Cannot add item to full stack.");
        front++;
        stack[front] = item;
    }

    @Override
    public T pop() {
        if (this.isEmpty())
            throw new IllegalArgumentException("Cannot remove item from empty stack.");
        front--;
        return stack[front+1];
    }

    @Override
    public T peek() {
        return this.isEmpty() ? null : stack[front];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return front == stack.length-1;
    }

    @Override
    public int size() {
        return stack.length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] getValues() {
        return (T[]) stack.clone();
    }
}
