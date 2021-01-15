package test.stacks;

import main.stacks.StaticStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StaticStackTest {

    @Test
    void testStaticStack() {
        StaticStack<Integer> stack = new StaticStack<>(3);
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        stack.push(3);
        assertTrue(stack.isFull());
        assertEquals(3, stack.pop());
    }
}