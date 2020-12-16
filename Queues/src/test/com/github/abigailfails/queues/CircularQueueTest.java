package test.com.github.abigailfails.queues;

import main.com.github.abigailfails.queues.CircularQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest {

    @Test
    void add() {
        CircularQueue<String> queue = new CircularQueue<>(new String[5]);
        for (int i = 0; i < 6; i++) {
            queue.add("musz.");
        }
        assertArrayEquals(new String[]{"musz.","musz.","musz.","musz.","musz."}, queue.get());
    }

    @Test
    void remove() {
    }

    @Test
    void isFull() {
    }

    @Test
    void isEmpty() {
    }
}