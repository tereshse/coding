package com.github.tereshse.arrays;

import org.junit.Test;

import static com.github.tereshse.arrays.RemoveDuplicatesFromSortedArray.bruteForceRemoveDuplicatesFromSortedArray;
import static com.github.tereshse.arrays.RemoveDuplicatesFromSortedArray.removeDuplicatesFromSortedArray;
import static org.assertj.core.api.Assertions.assertThat;


public class RemoveDuplicatesFromSortedArrayTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfArrayIsNull() {
        bruteForceRemoveDuplicatesFromSortedArray(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfArrayIsNotSorted() {
        bruteForceRemoveDuplicatesFromSortedArray(new int[]{1, 2, -1});
    }


    @Test
    public void shouldNotModifyArrayIfThereAreNoDuplicates() {
        int[] array = new int[]{1, 2, 3};
        assertThat(bruteForceRemoveDuplicatesFromSortedArray(array)).isEqualTo(3);
        assertThat(array).containsExactly(1, 2, 3);
    }


    @Test
    public void shouldModifyArrayIfThereAreDuplicates() {
        int[] array = new int[]{1, 2, 2, 3};
        assertThat(bruteForceRemoveDuplicatesFromSortedArray(array)).isEqualTo(3);
        assertThat(array).containsExactly(1, 2, 3, Integer.MIN_VALUE);

        array = new int[]{1, 1, 2, 2, 3, 3};
        assertThat(bruteForceRemoveDuplicatesFromSortedArray(array)).isEqualTo(3);
        assertThat(array).containsExactly(1, 2, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Test
    public void shouldModifyArrayIfThereAreDuplicatesOptimal() {
        int[] array = new int[]{1, 2, 2, 3};
        assertThat(removeDuplicatesFromSortedArray(array)).isEqualTo(3);
        assertThat(array).containsExactly(1, 2, 3, 3);

        array = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        assertThat(removeDuplicatesFromSortedArray(array)).isEqualTo(3);
        assertThat(array).containsExactly(1, 2, 3, 1, 2, 2, 2, 3, 3, 3);
    }


    @Test
    public void testIsSorted() {
        assertThat(RemoveDuplicatesFromSortedArray.isSorted(null)).isTrue();
        assertThat(RemoveDuplicatesFromSortedArray.isSorted(new int[]{1})).isTrue();
        assertThat(RemoveDuplicatesFromSortedArray.isSorted(new int[]{1, 2})).isTrue();
        assertThat(RemoveDuplicatesFromSortedArray.isSorted(new int[]{0, 0, 0, 1, 1, 2})).isTrue();
        assertThat(RemoveDuplicatesFromSortedArray.isSorted(new int[]{3, 1})).isFalse();
    }
}