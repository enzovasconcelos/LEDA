package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import java.util.Arrays;
import static util.Util.swap;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
	    if(leftIndex < 0 || rightIndex >= array.length)
            return;

        if(leftIndex >= rightIndex)
            return;

        // Obtendo mediana
        T[] a = (T[]) new Comparable[3];
        a[0] = array[leftIndex];
        int middleIndex = (leftIndex + rightIndex) / 2;
        a[1] = array[middleIndex];
        a[2] = array[rightIndex]; 
        sort3(a); 
        
        // Particiona
        T pivot = a[1];
        mySwap(array, rightIndex, a[2], a, leftIndex, rightIndex);
        mySwap(array, leftIndex, a[0], a, leftIndex, rightIndex);
        mySwap(array, rightIndex - 1, pivot, a, leftIndex, rightIndex);
        int changeIndex = rightIndex - 2;
        for(int indice = rightIndex - 2; indice > leftIndex; indice--) {
            if(array[indice].compareTo(pivot) > 0) {
                swap(array, indice, changeIndex);
                changeIndex--;   
            }
        }
        swap(array, rightIndex - 1, changeIndex + 1);
        // Chamando pra esqueda do pivot
        sort(array, leftIndex, changeIndex);
        // Chamando pra direita do pivot
        sort(array, changeIndex + 2, rightIndex);
	}

    private void mySwap(T[] array, int index, T element, T[] a, int left, int right) {
        int indexElement = 0;
        if(array[left].equals(element))
            indexElement = left;
        else if(array[right].equals(element))
            indexElement = right;
        else {
            int middle = (left + right) / 2;
            indexElement = middle;
        }
        swap(array, index, indexElement);
    }

    private void sort3(T[] array) {
        Arrays.sort(array);
    }
}
