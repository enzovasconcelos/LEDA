package sorting.simpleSorting;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
        // Não ordena se o índices estiverem fora dos limites do array
        if(leftIndex < 0 || rightIndex >= array.length)
            return;

        for(int vezes = 0; vezes < rightIndex - leftIndex; vezes++) {
            for(int indice = leftIndex; indice < rightIndex - vezes; indice++) {
                if(array[indice].compareTo(array[indice + 1]) > 0)
                    swap(array, indice, indice+1);
            }
        }
	}
}
