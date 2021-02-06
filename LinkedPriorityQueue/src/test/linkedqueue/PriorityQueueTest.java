/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedqueue;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * @author flowers
 */
public class PriorityQueueTest {
    private static PriorityQueue<String> createQueueAndAdd() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("1", 1);
        queue.add("4", 4);
        queue.add("5", 3);
        queue.add("2", 2);
        queue.add("3", 3);
        queue.add("6", 1);
        return queue;
    }

    @Test
    public void isEmptyTest1() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        assertTrue("Testing isEmpty(), queue = {}", queue.isEmpty());
    }

    @Test
    public void isEmptyTest2() {
        PriorityQueue<String> queue = createQueueAndAdd();
        assertFalse("Testing isEmpty(), queue = {1,6,2,5,3,4}", queue.isEmpty());
    }

    @Test
    public void addTest() {
        assertArrayEquals("Testing add(), queue = {1,6,2,5,3,4}", new String[]{"1","6","2","5","3","4"}, createQueueAndAdd().asArray());
    }

    @Test
    public void popTest1() {
       PriorityQueue<String> queue = createQueueAndAdd();
       queue.pop();
       queue.add("3", 3);
       assertArrayEquals("Testing pop(), queue = {6,2,5,3,3,4}", new String[]{"6","2","5","3","3","4"}, queue.asArray());
    }

    @Test
    public void popTest2() throws NoSuchFieldException, IllegalAccessException {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("3", 3);
        queue.add("4", 2);
        queue.pop();
        queue.pop();
        Field front = PriorityQueue.class.getDeclaredField("front");
        front.setAccessible(true);
        assertNull("Testing that front is null after pop(), queue = {}", front.get(queue));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTest1() {
        PriorityQueue<String> queue = createQueueAndAdd();
        queue.pop();
        queue.add("3", 3);
        queue.remove("1");
    }

    @Test
    public void removeTest2() {
        PriorityQueue<String> queue = createQueueAndAdd();
        queue.pop();
        queue.add("3", 3);
        queue.remove("3");
        assertArrayEquals("Testing remove(), queue = {6,2,5,3,4}", new String[]{"6","2","5","3","4"}, queue.asArray());
    }

    @Test
    public void removeTest3() throws NoSuchFieldException, IllegalAccessException {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("3", 3);
        queue.add("4", 2);
        queue.remove("3");
        queue.remove("4");
        Field front = PriorityQueue.class.getDeclaredField("front");
        front.setAccessible(true);
        assertNull("Testing that front is null after remove(), queue = {}", front.get(queue));
    }

    @Test
    public void lengthTest1() {
        assertEquals("Testing length(), queue = {}", 0, new PriorityQueue<>().length());
    }

    @Test
    public void lengthTest2() {
        assertEquals("Testing length(), queue = {1,6,2,5,3,4}", 6, createQueueAndAdd().length());
    }

    @Test
    public void lengthTest3() {
        PriorityQueue<String> queue = createQueueAndAdd();
        queue.pop();
        queue.remove("3");
        assertEquals("Testing length(), queue = {6,2,5,4}", 4, queue.length());
    }

    @Test
    public void countTest1() {
        assertEquals("Testing count(), queue = {}", 0, new PriorityQueue<>().count("7"));
    }

    @Test
    public void countTest2() {
        assertEquals("Testing count(), queue = {}", 0, createQueueAndAdd().count("7"));
    }

    @Test
    public void countTest3() {
        assertEquals("Testing count(), queue = {1,6,2,5,3,4}", 1, createQueueAndAdd().count("3"));
    }

    @Test
    public void countTest4() {
        PriorityQueue<String> queue = createQueueAndAdd();
        queue.add("3", 4);
        assertEquals("Testing count(), queue = {1,6,2,5,3,4,3}", 2, queue.count("3"));
    }
}