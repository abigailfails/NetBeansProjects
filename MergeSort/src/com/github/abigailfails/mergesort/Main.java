package com.github.abigailfails.mergesort;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static<T extends Comparable<T>> void sort(T[] array) {

    }

    @SuppressWarnings("unchecked")
    private static<T extends Comparable<T>> T[] merge(T[] array1, T[] array2) {
        T[] sorted = (T[]) Array.newInstance(array1[0].getClass(), array1.length + array2.length);
        //TODO fix duplication!!!!
        if (!isSorted(array1)) {
            T[] half1 = (T[]) Array.newInstance(array1[0].getClass(), array1.length / 2);
            T[] half2 = (T[]) Array.newInstance(array1[0].getClass(), 1 - (array1.length / 2));
            System.arraycopy(array1, 0, half1, 0, array1.length / 2);
            System.arraycopy(array1, (array1.length / 2) + 1, half2, 0, 1 - (array1.length / 2));
            array1 = merge(half1, half2);
        }
        if (!isSorted(array2)) {
            T[] half1 = (T[]) Array.newInstance(array2[0].getClass(), array2.length / 2);
            T[] half2 = (T[]) Array.newInstance(array2[0].getClass(), 1 - (array2.length / 2));
            System.arraycopy(array2, 0, half1, 0, array2.length / 2);
            System.arraycopy(array2, (array2.length / 2) + 1, half2, 0, 1 - (array2.length / 2));
            array2 = merge(half1, half2);
        }
        //TODO now do ordery thing! Possible recursion? Check presentation for merging 2 lists
        return sorted; //huehuehue null
    }

    private static<T extends Comparable<T>> boolean isSorted(T[] array) {
        T previous = null;
        for (T t : array) {
            if (previous != null && t.compareTo(previous) < 0)
                return false;
            previous = t;
        }
        return true;
    }

}
