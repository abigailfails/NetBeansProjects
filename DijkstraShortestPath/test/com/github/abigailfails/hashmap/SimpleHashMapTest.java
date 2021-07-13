package com.github.abigailfails.hashmap;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SimpleHashMapTest {
    //TODO switch to entry set checking when has time

    @Test
    public void test1isEmpty() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        assertTrue("Test 1: isEmpty {,,,,,,,,,,}", map.isEmpty());
    }
    
    @Test
    public void test2put54Bill() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        map.put(54, "Bill");
        assertArrayEquals("Test 2: put 54:Bill: {54:Bill}", new String[]{"Bill"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test3put26Ben() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        map.put(54, "Bill");
        map.put(26, "Ben");
        assertArrayEquals("Test 3: put 26:Ben: {26:Ben,54:Bill}", new String[]{"Ben","Bill"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test4put93Bob() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        map.put(54, "Bill");
        map.put(26, "Ben");
        map.put(93, "Bob");
        assertArrayEquals("Test 4: put 93:Bob: {26:Ben,54:Bill,93:Bob}", new String[]{"Ben","Bill","Bob"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test5put17Benny() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        map.put(54, "Bill");
        map.put(26, "Ben");
        map.put(93, "Bob");
        map.put(17, "Benny");
        assertArrayEquals("Test 5: put 17:Benny: {26:Ben,17:Benny,54:Bill,93:Bob}", new String[]{"Ben","Benny","Bill","Bob"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test6put77Benji() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        map.put(54, "Bill");
        map.put(26, "Ben");
        map.put(93, "Bob");
        map.put(17, "Benny");
        map.put(77, "Benji");
        assertArrayEquals("Test 6: put 77:Benji: {26:Ben,77:Benji,17:Benny,54:Bill,93:Bob}", new String[]{"Ben","Benji","Benny","Bill","Bob"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test7put31Banksy() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        map.put(54, "Bill");
        map.put(26, "Ben");
        map.put(93, "Bob");
        map.put(17, "Benny");
        map.put(77, "Benji");
        map.put(31, "Banksy");
        assertArrayEquals("Test 7: put 31:Banksy: {31:Banksy,26:Ben,77:Benji,17:Benny,54:Bill,93:Bob}", new String[]{"Banksy","Ben","Benji","Benny","Bill","Bob"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test8put65Bobby() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        map.put(54, "Bill");
        map.put(26, "Ben");
        map.put(93, "Bob");
        map.put(17, "Benny");
        map.put(77, "Benji");
        map.put(31, "Banksy");
        map.put(65, "Bobby");
        assertArrayEquals("Test 8: put 65:Bobby: {31:Banksy,26:Ben,77:Benji,17:Benny,54:Bill,93:Bob,65:Bobby}", new String[]{"Banksy","Ben","Benji","Benny","Bill","Bob","Bobby"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test9put11Bernard() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        map.put(54, "Bill");
        map.put(26, "Ben");
        map.put(93, "Bob");
        map.put(17, "Benny");
        map.put(77, "Benji");
        map.put(31, "Banksy");
        map.put(65, "Bobby");
        map.put(11, "Bernard");
        assertArrayEquals("Test 9: put 11:Bernard: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,93:Bob,65:Bobby}", new String[]{"Banksy","Ben","Benji","Benny","Bernard","Bill","Bob","Bobby"}, map.values().stream().sorted().toArray());
    }

    private SimpleHashMap<Integer, String> createUpToBilly() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>(11);
        map.put(54, "Bill");
        map.put(26, "Ben");
        map.put(93, "Bob");
        map.put(17, "Benny");
        map.put(77, "Benji");
        map.put(31, "Banksy");
        map.put(65, "Bobby");
        map.put(11, "Bernard");
        map.put(53, "Billy");
        return map;
    }

    @Test
    public void test10put53Billy() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        assertArrayEquals("Test 10: put 53:Billy: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob,65:Bobby}", new String[]{"Banksy","Ben","Benji","Benny","Bernard","Bill","Billy","Bob","Bobby"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test11isEmpty() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        assertFalse("Test 11: isEmpty: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob,65:Bobby}", map.isEmpty());
    }

    @Test
    public void test12size() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        assertEquals("Test 12: size: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob,65:Bobby}", 9, map.size());
    }

    @Test
    public void test13get53() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        assertEquals("Test 13: get 53: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob,65:Bobby}", "Billy", map.get(53));
    }

    @Test
    public void test14get99() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        assertNull("Test 14: get 99: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob,65:Bobby}", map.get(99));
    }

    @Test
    public void test15containsKey11() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        assertTrue("Test 15: containsKey 11: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob,65:Bobby}", map.containsKey(11));
    }

    @Test
    public void test16containsKey13() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        assertFalse("Test 16: containsKey 13: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob,65:Bobby}", map.containsKey(13));
    }

    @Test
    public void test17remove65() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        assertEquals("Bobby", map.remove(65));
        assertArrayEquals("Test 17: remove 65: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob}", new String[]{"Banksy","Ben","Benji","Benny","Bernard","Bill","Billy","Bob"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test18remove99() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        map.remove(65);
        assertNull("Test 18: remove 99: {31:Banksy,26:Ben,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob}", map.remove(99));
    }

    @Test
    public void test19size() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        map.remove(65);
        assertEquals(8, map.size());
    }

    @Test
    public void test20put12Benji() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        map.remove(65);
        map.put(12, "Benji");
        assertArrayEquals("Test 20: put 12:Benji: {31:Banksy,26:Ben,12:Benji,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob}", new String[]{"Banksy","Ben","Benji","Benji","Benny","Bernard","Bill","Billy","Bob"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test21put28Butch() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        map.remove(65);
        map.put(12, "Benji");
        map.put(28, "Butch");
        assertArrayEquals("Test 21: put 28:Butch: {31:Banksy,26:Ben,12:Benji,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,93:Bob,28:Butch}", new String[]{"Banksy","Ben","Benji","Benji","Benny","Bernard","Bill","Billy","Bob","Butch"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test22put77Blobby() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        map.remove(65);
        map.put(12, "Benji");
        map.put(28, "Butch");
        map.put(77, "Blobby");
        assertArrayEquals("Test 22: put 77:Blobby: {31:Banksy,26:Ben,12:Benji,77:Blobby,17:Benny,11:Bernard,54:Bill,53:Billy,77:Blobby,93:Bob,28:Butch}", new String[]{"Banksy","Ben","Benji","Benny","Bernard","Bill","Billy","Blobby","Bob","Butch"}, map.values().stream().sorted().toArray());
    }

    @Test
    public void test23put41Blinky() {
        SimpleHashMap<Integer, String> map = createUpToBilly();
        map.remove(65);
        map.put(12, "Benji");
        map.put(28, "Butch");
        map.put(41, "Blinky");
        assertArrayEquals("Test 24: put 41:Blinky: {31:Banksy,26:Ben,12:Benji,77:Benji,17:Benny,11:Bernard,54:Bill,53:Billy,41:Blinky,93:Bob,28:Butch}", new String[]{"Banksy","Ben","Benji","Benji","Benny","Bernard","Bill","Billy","Blinky","Bob","Butch"}, map.values().stream().sorted().toArray());
    }
}
