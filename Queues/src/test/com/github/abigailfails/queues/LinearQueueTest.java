package test.com.github.abigailfails.queues;

import main.com.github.abigailfails.queues.LinearQueue;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

//Requires JUnit 5.4
class LinearQueueTest {

    @Test
    void mainTest() {
        LinearQueue<Integer> queue = new LinearQueue<>(new Integer[4]);
        Integer[] expectedValues = {1,2,3,4};
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        queue.add(4);
        try {
            Field queueField = LinearQueue.class.getDeclaredField("queue");
            queueField.setAccessible(true);
            assertArrayEquals(expectedValues, (Integer[]) queueField.get(queue));
        }
        catch (NoSuchFieldException e) {
            fail("Field 'queue' did not exist! Something is very wrong with LinearQueue.");
        }
        catch (IllegalAccessException e) {
            fail("Field 'queue' could not be accessed! Something is very wrong with LinearQueue.");
        }
    }

    @Test
    void enQueue() {
        LinearQueue<Integer> queue = new LinearQueue<>(new Integer[2]);
        queue.add(4);
        queue.add(2);
        assertArrayEquals(new Integer[]{4,2}, queue.get());
    }

    @Test
    void deQueue() {
        LinearQueue<Integer> queue = new LinearQueue<>(new Integer[1]);
        queue.add(1);
        assertEquals(1, queue.remove());
    }

    @Test
    void isEmpty() {
        LinearQueue<Integer> queue = new LinearQueue<>(new Integer[1]);
        assertTrue(queue.isEmpty());
    }

    @Test
    void isFull() {
        LinearQueue<Integer> queue = new LinearQueue<>(new Integer[3]);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertTrue(queue.isFull());
    }
}