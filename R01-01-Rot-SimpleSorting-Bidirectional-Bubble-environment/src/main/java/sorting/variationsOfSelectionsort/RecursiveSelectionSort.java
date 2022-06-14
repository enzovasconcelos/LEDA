package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import static util.Util.swap;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    if(leftIndex < 0 || rightIndex >= array.length)
            return;
        if(leftIndex >= rightIndex)
            return;
        
        int indexMenor = leftIndex;
        for(int atual = leftIndex + 1; atual <= rightIndex; atual++) {
            if(array[atual].compareTo(array[indexMenor]) >= 0) continue;
            indexMenor = atual;
        }
        swap(array, indexMenor, leftIndex);
        sort(array, leftIndex + 1, rightIndex);
	}

}
