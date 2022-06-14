package sorting.divideAndConquer;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    if(leftIndex < 0 || rightIndex >= array.length)
            return;
        if(leftIndex >= rightIndex)
            return;
        int pivotIndex = particiona(array, leftIndex, rightIndex);
        sort(array, leftIndex, pivotIndex - 1);
        sort(array, pivotIndex + 1, rightIndex);
	}

    private int particiona(T[] array, int leftIndex, int rightIndex) {
        T pivot = array[leftIndex];
        int changeIndex = leftIndex + 1;
        for(int index = leftIndex + 1; index <= rightIndex; index++) {
            if(array[index].compareTo(pivot) > 0) continue;
            swap(array, changeIndex, index);
            changeIndex++;
        }
        swap(array, changeIndex - 1, leftIndex);
        return changeIndex - 1;
    }
}
