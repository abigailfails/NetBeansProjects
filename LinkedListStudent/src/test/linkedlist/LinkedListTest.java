package linkedlist;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author water
 */
public class LinkedListTest
{
    @Test
    public void test1isEmpty()
    {
        System.out.println("Test 1: isEmpty(), {}");
        LinkedList<String> pq = new LinkedList<>();
        assertTrue("isEmpty(): True, {}", pq.isEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test2pop()
    {
        System.out.println("Test 2: pop(), {}");
        LinkedList<String> pq = new LinkedList<>();
        pq.pop();
    }

    @Test
    public void test3length()
    {
        System.out.println("Test 3: length(), {}");
        LinkedList<String> pq = new LinkedList<>();
        assertEquals("Test 3: length(), {}", 0, pq.length());
    }

    @Test
    public void test4append1()
    {
        System.out.println("Test 4: append 1: {1}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        Assert.assertArrayEquals("Test 4: append 1: {1}", new String[]{"1"}, pq.asArray());
    }

    @Test
    public void test5length()
    {
        System.out.println("Test 5: length() , {1}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        assertEquals("Test 5: length(), {1}", 1, pq.length());
    }

    @Test
    public void test6append4()
    {
        System.out.println("Test 6: append 4: {1, 4}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        Assert.assertArrayEquals("Test 6: append 4: {1, 4}", new String[]{"1","4"}, pq.asArray());
    }

    @Test
    public void test7append5()
    {
        System.out.println("Test 7: append 5: {1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        Assert.assertArrayEquals("Test 7: append 5: {1, 4, 5}", new String[]{"1","4", "5"}, pq.asArray());
    }

    @Test
    public void test8index4()
    {
        System.out.println("Test 8: index 4 : {1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        assertEquals("Test 8: index 4: {1, 4, 5}", 1, pq.index("4"));
    }

    @Test
    public void test9index6()
    {
        System.out.println("Test 9: index 6 : {1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        assertTrue("Test 9: index 6: {1, 4, 5}", pq.index("6") < 0);
    }

    @Test
    public void test10insert31()
    {
        System.out.println("Test 10: insert (3, 1) : {1, 3, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        Assert.assertArrayEquals("Test 10: insert (1,3) : {1, 3, 4, 5}", new String[]{"1","3", "4", "5"}, pq.asArray());
    }

    @Test
    public void test11append5()
    {
        System.out.println("Test 11: append 5 : {1, 3, 4, 5, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        Assert.assertArrayEquals("Test 11: append 5 : {1, 3, 4, 5, 5}", new String[]{"1","3", "4", "5", "5"}, pq.asArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test12insert35()
    {
        System.out.println("Test 12: insert (3, 5) : {1, 3, 4, 5, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("3", 5);
    }

    @Test
    public void test13insert35()
    {
        System.out.println("Test 13: insert (2, 0) : {2, 1, 3, 4, 5, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        //Deleted insert that will throw IllegalArgumentException as assertArrayEquals implies it's supposed to reach the end
        pq.insert("2", 0);
        Assert.assertArrayEquals("Test 13: insert (2, 0) : {2, 1, 3, 4, 5, 5}", new String[]{"2", "1","3", "4", "5", "5"}, pq.asArray());
    }

    @Test
    public void test14remove5()
    {
        System.out.println("Test 14: remove 5 : {2, 1, 3, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("2", 0);
        pq.remove("5");
        Assert.assertArrayEquals("Test 14: remove 5 : {2, 1, 3, 4, 5}", new String[]{"2", "1","3", "4", "5"}, pq.asArray());
    }

    @Test
    public void test15pop2()
    {
        System.out.println("Test 15: pop 2 : {2, 1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("2", 0);
        pq.remove("5");
        pq.pop(2);
        Assert.assertArrayEquals("Test 15: pop 2 : {2, 1, 4, 5}", new String[]{"2", "1", "4", "5"}, pq.asArray());
    }

    @Test
    public void test16pop4()
    {
        System.out.println("Test 16: pop 4 : {2, 1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("2", 0);
        pq.remove("5");
        pq.pop(2);
        Assert.assertArrayEquals("Test 16: pop 4 : {2, 1, 4, 5}", new String[]{"2", "1", "4", "5"}, pq.asArray());
    }

    @Test
    public void test17isEmpty()
    {
        System.out.println("Test 17: isEmpty : {2, 1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("2", 0);
        pq.remove("5");
        pq.pop(2);
        assertFalse("Test 17: isEmpty : {2, 1, 4, 5}", pq.isEmpty());
    }

    @Test
    public void test18search4()
    {
        System.out.println("Test 18: search 4 : {2, 1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("2", 0);
        pq.remove("5");
        pq.pop(2);
        assertTrue("Test 18: search 4 : {2, 1, 4, 5}", pq.search("4"));
    }

    @Test
    public void test19search3()
    {
        System.out.println("Test 19: search 3 : {2, 1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("2", 0);
        pq.remove("5");
        pq.pop(2);
        assertFalse("Test 19: search 3 : {2, 1, 4, 5}", pq.search("3"));
    }

    @Test
    public void test20pop()
    {
        System.out.println("Test 20: pop : {1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("2", 0);
        pq.remove("5");
        pq.pop(2);
        pq.pop();
        Assert.assertArrayEquals("Test 20: pop : {1, 4, 5}", new String[]{"1", "4", "5"}, pq.asArray());
    }

    @Test
    public void test21length()
    {
        System.out.println("Test 21: length : {1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("2", 0);
        pq.remove("5");
        pq.pop(2);
        pq.pop();
        assertEquals("Test 21: length : {1, 4, 5}", 3, pq.length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test22Remove() {
        System.out.println("Test 22: remove 7 : {1, 4, 5}");
        LinkedList<String> pq = new LinkedList<>();
        pq.append("1");
        pq.append("4");
        pq.append("5");
        pq.insert("3",1);
        pq.append("5");
        pq.insert("2", 0);
        pq.remove("5");
        pq.pop(2);
        pq.pop();
        pq.remove("7");
    }
}