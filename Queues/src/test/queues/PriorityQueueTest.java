package test.queues;

import main.queues.PriorityQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    @Test
    void mainTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        assertTrue(queue.isEmpty());
        queue.add(5,2);
        queue.add(3, 2);
        queue.add(10, 1);
        queue.add(7, 1);
        assertArrayEquals(new Integer[]{10,7,5,3}, queue.values().toArray());
        queue.remove();
        assertArrayEquals(new Integer[]{7,5,3}, queue.values().toArray());
    }

    @Test
    void isFull() {
        PriorityQueue<Character> queue = new PriorityQueue<>(1);
        queue.add('a', 1);
        assertTrue(queue.isFull());
    }

    @Test
    void peek() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4,1);
        queue.add(3,1);
        queue.add(2,1);
        assertEquals(4, queue.peek());
    }
}