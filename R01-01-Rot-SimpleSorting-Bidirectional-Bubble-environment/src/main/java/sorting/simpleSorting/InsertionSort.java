package sorting.simpleSorting;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    // Não ordena se o índices estiverem fora dos limites do array
        if(leftIndex < 0 || rightIndex >= array.length)
            return;	

        for(int indice = leftIndex + 1; indice <= rightIndex; indice++) {
            //inserir ordenado
            for(int i = indice; i > leftIndex; i--) {
                if(array[i].compareTo(array[i - 1]) >= 0)
                    break;
                swap(array, i, i - 1);
            }
        }
	}
}
