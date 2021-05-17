package com.github.abigailfails.mergesort;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Random;

public class ArrayMergeSort {

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(sorted(new Integer[]{130691206,7,2,0,34,3,9,130691207,-1050,21,100,7,-3,1,8})));
        System.out.println(Arrays.toString(sorted(new Double[]{3.0,-12359.0,-12359.2,89.000001,89.0,23.5,120591036.0,3.141592653,8.0,6.9})));
        System.out.println(Arrays.toString(sorted(new String[]{"Drucilla", "Sherryl", "Huey", "Hannah", "Gerry", "Heidi", "Brendon", "Mckinley", "Pricilla", "Talisha"})));
        System.out.println(Arrays.toString(sorted(new String[]{"we do a little trolling", "we do a little tricking"})));
        int numberOfElements = 100000000;
        Integer[] weewoo = new Integer[numberOfElements]; //removing 2 digits makes it way faster, bad scaling?
        Random random = new Random();
        for(int i=0; i< weewoo.length; i++) {
            weewoo[i] = random.nextInt();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("T:\\Computing\\Simple Java Projects\\MergeSort\\running time.txt", true));
        BufferedReader reader = new BufferedReader(new FileReader("T:\\Computing\\Simple Java Projects\\MergeSort\\running time.txt"));
        String firstLine = reader.readLine();
        if (!(firstLine == null || firstLine.isEmpty())) {
            writer.newLine();
            writer.newLine();
        }
        LocalDateTime startTime = LocalDateTime.now();
        writer.append("Testing sort time for array of ").append(String.valueOf(numberOfElements)).append(" elements.");
        writer.newLine();
        writer.append("Start: ").append(startTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        sort(weewoo);
        LocalDateTime endTime = LocalDateTime.now();
        writer.newLine();
        writer.append("End: ").append(endTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        writer.newLine();
        writer.append("Execution took ").append(String.valueOf(startTime.until(endTime, ChronoUnit.MILLIS))).append("ms.");
        writer.close();
        System.out.println(Arrays.toString(weewoo));
    }

    /**
     * Sorts {@code array} using a merge sort, and returns the sorted array.
     *
     * <p>Useful for concise calls.</p>
     * @param array the array to sort
     * @param <T> the {@link Comparable} type of data to sort
     *
     * @return the sorted array
     *
     * @see ArrayMergeSort#sort(Comparable[])
     */
    public static <T extends Comparable<T>> T[] sorted(T[] array) {
        sort(array);
        return array;
    }

    /**
     * Sorts {@code array} using a merge sort.
     *
     * @param array the array to sort
     * @param <T> the {@link Comparable} type of data to sort
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] array) {
        //Splits the array in 2 using System.arraycopy - more efficient than for loop
        int length = array.length;
        if (length <= 1) return;
        int half1Length = length / 2;
        int half2Length = length - (length / 2);
        T[] half1 = (T[]) Array.newInstance(array[0].getClass(), half1Length);
        T[] half2 = (T[]) Array.newInstance(array[0].getClass(), half2Length);
        System.arraycopy(array, 0, half1, 0, half1Length);
        System.arraycopy(array, half1Length, half2, 0, half2Length);
        //Sorts the array by populating it with the merged halves
        System.arraycopy(merge(half1, half2), 0, array, 0, length);
    }

    /**
     * Internal method used to merge two sublists while doing a merge sort.
     *
     * <p>Called by {@link ArrayMergeSort#sort(Comparable[])}</p>, and calls the method
     * recursively to split the arrays down further.
     *
     * @param array1 the first array to merge
     * @param array2 the second array to merge
     * @param <T> the {@link Comparable} type of data to sort
     *
     * @return the sorted list of the elements in {@code array1} and {@code array2}
     *
     * @see ArrayMergeSort#sort(Comparable[])
     */
    @SuppressWarnings("unchecked")
    private static<T extends Comparable<T>> T[] merge(T[] array1, T[] array2) {
        T[] sorted = (T[]) Array.newInstance(array1[0].getClass(), array1.length + array2.length);
        //Splits arrays greater than 1
        if (array1.length > 1) sort(array1);
        if (array2.length > 1) sort(array2);
        int array1Index = 0;
        int array2Index = 0;
        for (int i=0; i<sorted.length; i++) {
            /*Statement prevents index out of bounds - only uses array 1 if the array 2 element is greater AND
            array1Index is still within the length. Otherwise, depends on whether array2Index is within the length.
            */
            boolean shouldUseArray1 = array2Index >= array2.length || (array1Index < array1.length && array1[array1Index].compareTo(array2[array2Index]) < 0);
            sorted[i] = shouldUseArray1 ? array1[array1Index] : array2[array2Index];
            if (shouldUseArray1) array1Index++;
            else array2Index++;
            /*Inserts items from both lists into a new list by keeping track of indexes in both - much more efficient
            for sorted lists because you can be sure there are no smaller elements further along the list
            */
        }
        return sorted;
    }
}
