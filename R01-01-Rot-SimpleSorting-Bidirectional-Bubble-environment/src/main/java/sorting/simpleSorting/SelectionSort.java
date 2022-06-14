package sorting.simpleSorting;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
        // Verificar se os índices estão fora do limite.
        if(leftIndex < 0 || rightIndex >= array.length)
            return;
    
	    for(int position = leftIndex; position < rightIndex; position++) {
            int indexSmallest = position;
            // achar o menor
            for(int current = position; current <= rightIndex; current++) {
                if(array[current].compareTo(array[indexSmallest]) < 0)
                    indexSmallest = current;
            }
            // trocar o menor com posição
            swap(array, position, indexSmallest);
        }	
	}
}
