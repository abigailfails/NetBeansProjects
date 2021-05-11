package com.github.abigailfails.mergesort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sorted(new Integer[]{130691206,7,2,0,34,3,9,130691207,-1050,21,100,7,-3,1,8})));
        System.out.println(Arrays.toString(sorted(new Double[]{3.0,-12359.0,-12359.2,89.000001,89.0,23.5,120591036.0,3.141592653,8.0,6.9})));
        System.out.println(Arrays.toString(sorted(new String[]{"Drucilla", "Sherryl", "Huey", "Hannah", "Gerry", "Heidi", "Brendon", "Mckinley", "Pricilla", "Talisha"})));
        System.out.println(Arrays.toString(sorted(new String[]{"we do a little trolling", "we do a little tricking"})));
    }

    public static <T extends Comparable<T>> T[] sorted(T[] array) {
        sort(array);
        return array;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;
        if (length <= 1)
            return;
        int half1Length = length / 2;
        int half2Length = length - (length / 2);
        T[] half1 = (T[]) Array.newInstance(array[0].getClass(), half1Length);
        T[] half2 = (T[]) Array.newInstance(array[0].getClass(), half2Length);
        System.arraycopy(array, 0, half1, 0, half1Length);
        System.arraycopy(array, half1Length, half2, 0, half2Length);
        System.arraycopy(merge(half1, half2), 0, array, 0, length);
    }

    @SuppressWarnings("unchecked")
    private static<T extends Comparable<T>> T[] merge(T[] array1, T[] array2) {
        T[] sorted = (T[]) Array.newInstance(array1[0].getClass(), array1.length + array2.length);
        if (/*!isSorted(array1)*/array1.length > 1)
            sort(array1);
        if (/*!isSorted(array2)*/array2.length > 1)
            sort(array2);
        int index1 = 0;
        int index2 = 0;
        for (int i=0; i<sorted.length; i++) {
            boolean shouldUseArray1 = index2 >= array2.length || (index1 < array1.length && array1[index1].compareTo(array2[index2]) < 0);
            sorted[i] = shouldUseArray1 ? array1[index1] : array2[index2];
            if (shouldUseArray1)
                index1++;
            else
                index2++;
        }
        return sorted;
    }

    //TODO abandoned because minor efficiency improvement is outweighed by many more n loops
    /*private static<T extends Comparable<T>> boolean isSorted(T[] array) {
        T previous = null;
        for (T t : array) {
            if (previous != null && t.compareTo(previous) < 0)
                return false;
            previous = t;
        }
        return true;
    }*/

}
