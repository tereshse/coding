package com.github.tereshse.arrays;

import com.google.common.base.Preconditions;


public class RemoveDuplicatesFromSortedArray {
    public static int bruteForceRemoveDuplicatesFromSortedArray(int[] array) {
        Preconditions.checkArgument(array != null);
        Preconditions.checkArgument(isSorted(array));
        int length = array.length;
        for (int i = 0; i < length - 1; ) {
            if (array[i] == array[i + 1]) {
                System.arraycopy(array, i + 1, array, i, length - i - 1);
                length--;
                array[length] = Integer.MIN_VALUE;
            } else {
                i++;
            }
        }
        return length;
    }

    public static int removeDuplicatesFromSortedArray(int[] array) {
        Preconditions.checkArgument(array != null);
        Preconditions.checkArgument(isSorted(array), "Array should be sorted.");
        int writeIndex = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[writeIndex - 1] != array[i]) {
                array[writeIndex++] = array[i];
            }
        }
        return writeIndex;
    }


    public static boolean isSorted(int[] array) {
        if (array == null || array.length < 2) {
            return true;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
