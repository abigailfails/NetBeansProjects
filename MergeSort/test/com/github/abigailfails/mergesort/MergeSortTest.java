package com.github.abigailfails.mergesort;

import org.junit.Test;

import static com.github.abigailfails.mergesort.MergeSort.*;
import static org.junit.Assert.*;

public class MergeSortTest {
    @Test
    public void test1SortAndSorted() {
        Integer[] array = new Integer[]{3,10,2,-1,8};
        sort(array);
        assertArrayEquals(sorted(new Integer[]{3,10,2,-1,8}), array);
    }
    
    @Test
    public void test2Empty() {
        assertArrayEquals(new Integer[0], sorted(new Integer[0]));
    }

    @Test
    public void test3OneInt() {
        assertArrayEquals(new Integer[]{3}, sorted(new Integer[]{3}));
    }

    @Test
    public void test4OrderedInts() {
        assertArrayEquals(new Integer[]{-4,-2,0,1,2,6,120,6346}, sorted(new Integer[]{-4,-2,0,1,2,6,120,6346}));
    }

    @Test
    public void test5UnorderedInts() {
        assertArrayEquals(new Integer[]{-4,-2,0,1,2,2,6,120,6346}, sorted(new Integer[]{2,120,-4,-2,0,6346,1,2,6}));
    }

    @Test
    public void test5UnorderedDoubles() {
        assertArrayEquals(new Double[]{-0.00001,0.0,0.00000000000001,0.00002,6.9,12043968.0}, sorted(new Double[]{12043968.0,0.00000000000001,0.0,0.00002,-0.00001,6.9}));
    }

    @Test
    public void test6UnorderedChars() {
        assertArrayEquals(new Character[]{'C','Z','b','c'}, sorted(new Character[]{'Z','b','c','C'}));
    }

    @Test
    public void test7UnorderedStrings() {
        assertArrayEquals(new String[]{"Brendon","Drucilla","Gerry","Hannah","Heidi","Huey","Mckinley","Pricilla","Sherryl","Talisha","lowercase"}, sorted(new String[]{"lowercase","Drucilla", "Sherryl", "Huey", "Hannah", "Gerry", "Heidi", "Brendon", "Mckinley", "Pricilla", "Talisha"}));
    }
}
