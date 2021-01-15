package main.stacks;


public class DynamicStack<T> extends AbstractStack<T> {
    private Object[] stack = new Object[0];

    @SuppressWarnings("unchecked")
    private T getItem(int index) {
        return (T) stack[index];
    }

    @Override
    public void push(T item) {
        Object[] newStack = new Object[stack.length+1];
        newStack[0] = item;
        if (!this.isEmpty()) System.arraycopy(stack, 0, newStack, 1, stack.length);
        stack = newStack;
    }

    @Override
    public T pop() {
        if (this.isEmpty())
            throw new IllegalArgumentException("Cannot remove item from empty stack.");
        T toRemove = getItem(0);
        Object[] newStack = new Object[stack.length-1];
        System.arraycopy(stack, 1, newStack, 0, newStack.length);
        stack = newStack;
        return toRemove;
    }

    @Override
    public T peek() {
        return getItem(0);
    }

    @Override
    public boolean isEmpty() {
        return stack.length == 0;
    }

    @Override
    public boolean isFull() {
        return false;
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
