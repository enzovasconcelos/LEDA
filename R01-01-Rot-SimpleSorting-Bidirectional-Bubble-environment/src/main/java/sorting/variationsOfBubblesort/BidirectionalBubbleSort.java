package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
        if(leftIndex < 0 || rightIndex >= array.length)
            return;

        while(leftIndex < rightIndex) {
            int numTrocas = 0;
    	    for(int index = leftIndex; index < rightIndex; index++)	{
                if(array[index].compareTo(array[index + 1]) > 0) {
                    swap(array, index, index + 1);
                    numTrocas++;
                }
            }
            rightIndex--;

            for(int index = rightIndex; index > leftIndex; index--) {
                if(array[index].compareTo(array[index - 1]) < 0) {
                    swap(array, index, index - 1);
                    numTrocas++;
                }
            }
            leftIndex++;
            if(numTrocas == 0) break;
        }
	}
}
