package sorting.divideAndConquer;

import sorting.AbstractSorting;
import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    if(leftIndex < 0 || rightIndex >= array.length)
            return;
    
        if(leftIndex >= rightIndex)
            return;

        int middle = (leftIndex + rightIndex) / 2;
        sort(array, leftIndex, middle);
        sort(array, middle + 1, rightIndex);
        merge(array, leftIndex, rightIndex);
	}

    private void merge(T[] array, int leftIndex, int rightIndex) {
        T[] helper = Arrays.copyOf(array, array.length);
        int meio = (leftIndex + rightIndex) / 2;
        int iArray1 = leftIndex;
        int iArray2 = meio + 1;
        int indiceArray = leftIndex;
        while(iArray1 <= meio && iArray2 <= rightIndex) {
            if(helper[iArray1].compareTo(helper[iArray2]) <= 0) {
                array[indiceArray] = helper[iArray1];
                iArray1++;
            } 
            else {
                array[indiceArray] = helper[iArray2];
                iArray2++;
            }
            indiceArray++;
        }
        while(iArray1 <= meio) {
            array[indiceArray] = helper[iArray1];
            indiceArray++;
            iArray1++;
        }
        while(iArray2 <= rightIndex) {
            array[indiceArray] = helper[iArray2];
            indiceArray++;
            iArray2++;
        }
    }
}
