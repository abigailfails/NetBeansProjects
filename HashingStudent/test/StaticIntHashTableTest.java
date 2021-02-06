/*
 * To cmapange tmapis license mapeader, cmapoose License mapeaders in Project Properties.
 * To cmapange tmapis template file, cmapoose Tools | Templates
 * and open tmape template in tmape editor.
 */

import hashing.StaticIntHashTable;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author dw
 */
public class StaticIntHashTableTest {

    @Test
    public void test1isEmpty() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        assertTrue("Test 1: isEmpty {,,,,,,,,,,}", map.isEmpty());
    }
    
    @Test
    public void test2add54Bill() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        map.add(54, "Bill");
        assertArrayEquals("Test 2: add 54:Bill: {,,,,,,,,,,54:Bill}", new String[]{null,null,null,null,null,null,null,null,null,null,"Bill"}, map.asArray());
    }

    @Test
    public void test3add26Ben() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        map.add(54, "Bill");
        map.add(26, "Ben");
        assertArrayEquals("Test 3: add 26:Ben: {,,,,26:Ben,,,,,,54:Bill}", new String[]{null,null,null,null,"Ben",null,null,null,null,null,"Bill"}, map.asArray());
    }

    @Test
    public void test4add93Bob() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        map.add(54, "Bill");
        map.add(26, "Ben");
        map.add(93, "Bob");
        assertArrayEquals("Test 4: add 93:Bob: {,,,,26:Ben,93:Bob,,,,,54:Bill}", new String[]{null,null,null,null,"Ben","Bob",null,null,null,null,"Bill"}, map.asArray());
    }

    @Test
    public void test5add17Benny() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        map.add(54, "Bill");
        map.add(26, "Ben");
        map.add(93, "Bob");
        map.add(17, "Benny");
        assertArrayEquals("Test 5: add 17:Benny: {,,,,26:Ben,93:Bob,17:Benny,,,,54:Bill}", new String[]{null,null,null,null,"Ben","Bob","Benny",null,null,null,"Bill"}, map.asArray());
    }

    @Test
    public void test6add77Benji() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        map.add(54, "Bill");
        map.add(26, "Ben");
        map.add(93, "Bob");
        map.add(17, "Benny");
        map.add(77, "Benji");
        assertArrayEquals("Test 6: add 77:Benji: {77:Benji,,,,26:Ben,93:Bob,17:Benny,,,,54:Bill}", new String[]{"Benji",null,null,null,"Ben","Bob","Benny",null,null,null,"Bill"}, map.asArray());
    }

    @Test
    public void test7add31Banksy() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        map.add(54, "Bill");
        map.add(26, "Ben");
        map.add(93, "Bob");
        map.add(17, "Benny");
        map.add(77, "Benji");
        map.add(31, "Banksy");
        assertArrayEquals("Test 7: add 31:Banksy: {77:Benji,,,,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", new String[]{"Benji",null,null,null,"Ben","Bob","Benny",null,null,"Banksy","Bill"}, map.asArray());
    }

    @Test
    public void test8add65Bobby() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        map.add(54, "Bill");
        map.add(26, "Ben");
        map.add(93, "Bob");
        map.add(17, "Benny");
        map.add(77, "Benji");
        map.add(31, "Banksy");
        map.add(65, "Bobby");
        assertArrayEquals("Test 8: add 65:Bobby: {77:Benji,65:Bobby,,,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", new String[]{"Benji","Bobby",null,null,"Ben","Bob","Benny",null,null,"Banksy","Bill"}, map.asArray());
    }

    @Test
    public void test9add11Bernard() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        map.add(54, "Bill");
        map.add(26, "Ben");
        map.add(93, "Bob");
        map.add(17, "Benny");
        map.add(77, "Benji");
        map.add(31, "Banksy");
        map.add(65, "Bobby");
        map.add(11, "Bernard");
        assertArrayEquals("Test 9: add 11:Bernard: {77:Benji,65:Bobby,11:Bernard,,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", new String[]{"Benji","Bobby","Bernard",null,"Ben","Bob","Benny",null,null,"Banksy","Bill"}, map.asArray());
    }

    private StaticIntHashTable<String> createUpToBilly() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        map.add(54, "Bill");
        map.add(26, "Ben");
        map.add(93, "Bob");
        map.add(17, "Benny");
        map.add(77, "Benji");
        map.add(31, "Banksy");
        map.add(65, "Bobby");
        map.add(11, "Bernard");
        map.add(53, "Billy");
        return map;
    }

    @Test
    public void test10add53Billy() {
        StaticIntHashTable<String> map = createUpToBilly();
        assertArrayEquals("Test 10: add 53:Billy: {77:Benji,65:Bobby,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", new String[]{"Benji","Bobby","Bernard","Billy","Ben","Bob","Benny",null,null,"Banksy","Bill"}, map.asArray());
    }

    @Test
    public void test11isEmpty() {
        StaticIntHashTable<String> map = createUpToBilly();
        assertFalse("Test 11: isEmpty: {77:Benji,65:Bobby,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", map.isEmpty());
    }

    @Test
    public void test12length() {
        StaticIntHashTable<String> map = createUpToBilly();
        assertEquals("Test 12: length: {77:Benji,65:Bobby,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", 9, map.length());
    }

    @Test
    public void test13item53() {
        StaticIntHashTable<String> map = createUpToBilly();
        assertEquals("Test 13: item 53: {77:Benji,65:Bobby,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", "Billy", map.item(53));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test14item99() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.item(99);
    }

    @Test
    public void test15contains11() {
        StaticIntHashTable<String> map = createUpToBilly();
        assertTrue("Test 15: contains 11: {77:Benji,65:Bobby,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", map.contains(11));
    }

    @Test
    public void test16contains13() {
        StaticIntHashTable<String> map = createUpToBilly();
        assertFalse("Test 16: contains 13: {77:Benji,65:Bobby,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", map.contains(13));
    }

    @Test
    public void test17delete65() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.delete(65);
        assertArrayEquals("Test 17: delete 65: {77:Benji,,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", new String[]{"Benji",null,"Bernard","Billy","Ben","Bob","Benny",null,null,"Banksy","Bill"}, map.asArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test18delete99() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.delete(65);
        map.delete(99);
    }

    @Test
    public void test19length() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.delete(65);
        assertEquals(8, map.length());
    }

    @Test
    public void test20add12Benji() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.delete(65);
        map.add(12, "Benji");
        assertArrayEquals("Test 20: add 12:Benji: {77:Benji,12:Benji,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", new String[]{"Benji","Benji","Bernard","Billy","Ben","Bob","Benny",null,null,"Banksy","Bill"}, map.asArray());
    }

    @Test
    public void test21add28Butch() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.delete(65);
        map.add(12, "Benji");
        map.add(28, "Butch");
        assertArrayEquals("Test 21: add 12:Benji: {77:Benji,12:Benji,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,28:Butch,,31:Banksy,54:Bill}", new String[]{"Benji","Benji","Bernard","Billy","Ben","Bob","Benny","Butch",null,"Banksy","Bill"}, map.asArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test22add77Blobby() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.delete(65);
        map.add(12, "Benji");
        map.add(28, "Butch");
        map.add(77, "Blobby");
    }

    @Test
    public void test23add41Blinky() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.delete(65);
        map.add(12, "Benji");
        map.add(28, "Butch");
        map.add(41, "Blinky");
        assertArrayEquals("Test 23: add 41:Blinky: {77:Benji,12:Benji,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,28:Butch,41:Blinky,31:Banksy,54:Bill}", new String[]{"Benji","Benji","Bernard","Billy","Ben","Bob","Benny","Butch","Blinky","Banksy","Bill"}, map.asArray());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test24add11Blanka() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.delete(65);
        map.add(12, "Benji");
        map.add(28, "Butch");
        map.add(41, "Blinky");
        map.add(9, "Blanka"); //Changed to a non-existent key so it'll throw the full exception, not the already exists exception
    }

    @Test
    public void test25isFull() {
        StaticIntHashTable<String> map = new StaticIntHashTable<>(11);
        assertFalse("Test 27: isFull: {,,,,,,,,,,}", map.isFull());

    }

    @Test public void test26IsFull() {
        StaticIntHashTable<String> map = createUpToBilly();
        assertFalse("Test 27: isFull: Test 11: isEmpty: {77:Benji,65:Bobby,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,,,31:Banksy,54:Bill}", map.isFull());
    }

    @Test
    public void test27isFull() {
        StaticIntHashTable<String> map = createUpToBilly();
        map.delete(65);
        map.add(12, "Benji");
        map.add(28, "Butch");
        map.add(41, "Blinky");
        assertTrue("Test 27: isFull: {77:Benji,12:Benji,11:Bernard,53:Billy,26:Ben,93:Bob,17:Benny,28:Butch,41:Blinky,31:Banksy,54:Bill}", map.isFull());
    }
}
