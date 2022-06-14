package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import static util.Util.swap;
import java.util.Arrays;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
        if(leftIndex < 0 || rightIndex >= array.length)
            return;

        T[] pedaco = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
        System.out.println(Arrays.toString(pedaco));
	    this.MERGESORT_APPLICATIONS = 0;	
	    this.INSERTIONSORT_APPLICATIONS = 0;
        int lengthInput = rightIndex - leftIndex + 1;
        if(lengthInput <= this.SIZE_LIMIT) {
            insertionSort(array, leftIndex, rightIndex);
            return;
        }
        int middleIndex = (leftIndex + rightIndex) / 2;
        sort(array, leftIndex, middleIndex);
        sort(array, middleIndex + 1, rightIndex);
        merge(array, leftIndex, rightIndex);
        pedaco = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
        System.out.println(Arrays.toString(pedaco));
	}

    private void insertionSort(T[] array, int leftIndex, int rightIndex) {
        this.INSERTIONSORT_APPLICATIONS++;
        for(int indiceDesordenado = 1; indiceDesordenado <= rightIndex; indiceDesordenado++) {
            for(int indiceAtual = indiceDesordenado; indiceAtual > leftIndex; indiceAtual--) {
                if(array[indiceAtual].compareTo(array[indiceAtual - 1]) >= 0)
                    break;
                swap(array, indiceAtual, indiceAtual - 1);
            }
        }
    }

    private void merge(T[] array, int leftIndex, int rightIndex) {
        this.MERGESORT_APPLICATIONS++;
        T[] helper = Arrays.copyOf(array, array.length);
        int iArray1 = leftIndex;
        int middleIndex = (leftIndex + rightIndex) / 2;
        int iArray2 = middleIndex + 1;
        int indiceArray = leftIndex;
        while(iArray1 <= middleIndex && iArray2 <= rightIndex) {
            if(helper[iArray1].compareTo(helper[iArray2]) <= 0)
                array[indiceArray] = helper[iArray1++];
            else
                array[indiceArray] = helper[iArray2++];
            indiceArray++;
        }
        while(iArray1 <= middleIndex) {
            array[indiceArray++] = helper[iArray1++];
        }
        while(iArray2 <= middleIndex) {
            array[indiceArray++] = helper[iArray2++];
        }
    }
}
