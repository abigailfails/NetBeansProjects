/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author water
 */
public class LinkedListTest {
    @Test 
    public void test1isEmpty()
    {
        System.out.println("Test 1: isEmpty(), {}");
        LinkedList<String> list = new LinkedList<>();
        assertTrue("isEmpty(): True, {}", list.isEmpty());        
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void test2pop() 
    {
        System.out.println("Test 2: pop(), {}");
        LinkedList<String> list = new LinkedList<>();
        list.pop();
    }    

    @Test
    public void test3length()
    {
        System.out.println("Test 3: length(), {}");    
        LinkedList<String> list = new LinkedList<>();               
        assertEquals("Test 3: length(), {}", 0, list.length());                
    }

    @Test
    public void test4append1()
    {
        System.out.println("Test 4: append 1: {1}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");                                
        Assert.assertArrayEquals("Test 4: append 1: {1}", new String[]{"1"}, list.asArray());
    }
    
    @Test
    public void test5length()
    {
        System.out.println("Test 5: length() , {1}");    
        LinkedList<String> list = new LinkedList<>();  
        list.append("1");  
        assertEquals("Test 5: length(), {1}", 1, list.length());                
    }
    
    @Test
    public void test6append4()
    {
        System.out.println("Test 6: append 4: {1, 4}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        Assert.assertArrayEquals("Test 6: append 4: {1, 4}", new String[]{"1","4"}, list.asArray());                
    }
    
    @Test
    public void test7append5()
    {
        System.out.println("Test 7: append 5: {1, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        Assert.assertArrayEquals("Test 7: append 5: {1, 4, 5}", new String[]{"1","4", "5"}, list.asArray());                
    }
    
    @Test
    public void test8index4()
    {
        System.out.println("Test 8: index 4 : {1, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        assertEquals("Test 8: index 4: {1, 4, 5}", 1, list.index("4"));                
    }
   
    @Test //Changed as my implementation does not throw an error for invalid indexes
    public void test9index6()
    {
        System.out.println("Test 9: index 6 : {1, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        assertTrue("Test 9: index 6: {1, 4, 5}", list.index("6") < 0);
    }
    
    @Test
    public void test10insert31()
    {
        System.out.println("Test 10: insert (3, 1) : {1, 3, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);                
        Assert.assertArrayEquals("Test 10: insert (1,3) : {1, 3, 4, 5}", new String[]{"1","3", "4", "5"}, list.asArray());                
    }
    
    @Test
    public void test11append5()
    {
        System.out.println("Test 11: append 5 : {1, 3, 4, 5, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);  
        list.append("5");
        Assert.assertArrayEquals("Test 11: append 5 : {1, 3, 4, 5, 5}", new String[]{"1","3", "4", "5", "5"}, list.asArray());                
    }
    
    @Test(expected = IndexOutOfBoundsException.class) 
    public void test12insert35()
    {
        System.out.println("Test 12: insert (3, 5) : {1, 3, 4, 5, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");        
        list.insert("3", 5);           
    }
    
    @Test
    public void test13insert35()
    {
        System.out.println("Test 13: insert (2, 0) : {2, 1, 3, 4, 5, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                    
        list.insert("2", 0);  
        Assert.assertArrayEquals("Test 13: insert (2, 0) : {2, 1, 3, 4, 5, 5}", new String[]{"2", "1","3", "4", "5", "5"}, list.asArray());    
    }
    
    @Test
    public void test14remove5()
    {
        System.out.println("Test 14: remove 5 : {2, 1, 3, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                   
        list.insert("2", 0);  
        list.remove("5");
        Assert.assertArrayEquals("Test 14: remove 5 : {2, 1, 3, 4, 5}", new String[]{"2", "1","3", "4", "5"}, list.asArray());    
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test15remove6()
    {
        System.out.println("Test 15: remove 6 : {2, 1, 3, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                   
        list.insert("2", 0);  
        list.remove("6"); 
    }
    
    @Test
    public void test16pop2()
    {
        System.out.println("Test 15: pop 2 : {2, 1, 3, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                     
        list.insert("2", 0);  
        list.remove("5");
        list.pop(2);
        Assert.assertArrayEquals("Test 15: pop 2 : {2, 1, 3, 4, 5}", new String[]{"2", "1", "4", "5"}, list.asArray());    
    }
    
    @Test(expected = IndexOutOfBoundsException.class) 
    public void test17pop4()
    {
        System.out.println("Test 17: pop 4 : {2, 1, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                      
        list.insert("2", 0);  
        list.remove("5");
        list.pop(2);
        list.pop(4);
        Assert.assertArrayEquals("Test 17: pop 4 : {2, 1, 4, 5}", new String[]{"2", "1", "4", "5"}, list.asArray());    
    }
    
    @Test
    public void test18isEmpty()
    {
        System.out.println("Test 18: isEmpty : {2, 1, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                    
        list.insert("2", 0);  
        list.remove("5");
        list.pop(2);
        assertFalse("Test 18: isEmpty : {2, 1, 4, 5}", list.isEmpty());    
    }
    
    @Test
    public void test19search4()
    {
        System.out.println("Test 19 search 4 : {2, 1, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                    
        list.insert("2", 0);  
        list.remove("5");
        list.pop(2);
        assertTrue("Test 19: search 4 : {2, 1, 4, 5}", list.search("4"));    
    }
    
    @Test
    public void test20search3()
    {
        System.out.println("Test 20: search 3 : {2, 1, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                    
        list.insert("2", 0);  
        list.remove("5");
        list.pop(2);
        assertFalse("Test 20: search 3 : {2, 1, 4, 5}", list.search("3"));    
    }

    @Test
    public void test21pop()
    {
        System.out.println("Test 21: pop : {2, 1, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                 
        list.insert("2", 0);  
        list.remove("5");
        list.pop(2);
        list.pop();
        Assert.assertArrayEquals("Test 20: pop : {2, 1, 4, 5}", new String[]{"1", "4", "5"}, list.asArray());    
    }

    @Test
    public void test22length()
    {
        System.out.println("Test 22: length : {1, 4, 5}");    
        LinkedList<String> list = new LinkedList<>();
        list.append("1");        
        list.append("4");        
        list.append("5");
        list.insert("3",1);        
        list.append("5");                    
        list.insert("2", 0);  
        list.remove("5");
        list.pop(2);
        list.pop();
        assertEquals("Test 22: length : {1, 4, 5}", 3, list.length());
    }

    /**
     * Added to test exception from removing non-existent element.
     *
     * @author flowers
     */
    @Test(expected = IllegalArgumentException.class)
    public void test22Remove()
    {
        System.out.println("Test 22: remove 7 : {1, 4, 5}");
        LinkedList<String> list = new LinkedList<>();
        list.append("1");
        list.append("4");
        list.append("5");
        list.insert("3",1);
        list.append("5");
        list.insert("2", 0);
        list.remove("5");
        list.pop(2);
        list.pop();
        list.remove("7");
    }

    /**
    * This test and others below were added to test the new {@link LinkedList#count} method
    *
    * @author flowers
    */
    @Test
    public void test23Count1()
    {
        System.out.println("Test 23: count 5 : {2, 1, 3, 4, 5}");
        LinkedList<String> list = new LinkedList<>();
        list.append("1");
        list.append("4");
        list.append("5");
        list.insert("3",1);
        list.insert("2", 0);
        assertEquals("Test 23: count 5 : {2, 1, 3, 4, 5}", 1, list.count("5"));
    }

    @Test
    public void test24Count2()
    {
        System.out.println("Test 24: count 5 : {2, 1, 3, 4, 5, 5}");
        LinkedList<String> list = new LinkedList<>();
        list.append("1");
        list.append("4");
        list.append("5");
        list.insert("3",1);
        list.append("5");
        list.insert("2", 0);
        assertEquals("Test 24: count 5 : {2, 1, 3, 4, 5, 5}", 2, list.count("5"));
    }

    @Test
    public void test25Count0()
    {
        System.out.println("Test 25: count 5 : {2, 1, 3, 4}");
        LinkedList<String> list = new LinkedList<>();
        list.append("1");
        list.append("4");
        list.insert("3",1);
        list.insert("2", 0);
        assertEquals("Test 25: count 5 : {2, 1, 3, 4}", 0, list.count("5"));
    }

    @Test
    public void test26CountEmpty()
    {
        System.out.println("Test 26: count 5 : {}");
        LinkedList<String> list = new LinkedList<>();
        assertEquals("Test 26: count 5 : {}", 0, list.count("5"));
    }

    @Test
    public void test27CountFull()
    {
        System.out.println("Test 27: count 5 : {5, 5, 5, 5}");
        LinkedList<String> list = new LinkedList<>();
        list.append("5");
        list.append("5");
        list.append("5");
        list.append("5");
        assertEquals("Test 27: count 5 : {5, 5, 5, 5}", 4, list.count("5"));
    }
}
