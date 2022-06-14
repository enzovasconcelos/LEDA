package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
	    if(leftIndex < 0 || rightIndex >= array.length)
            return;

        if(leftIndex >= rightIndex)
            return;

        Integer[] valores = encontraMaiorEMenor(array, leftIndex, rightIndex);
        Integer menor = valores[0];
        Integer maior = valores[1];
        int tamanhoArray = maior - menor + 1;
        int[] frequencia = new int[tamanhoArray];
        
        // Conta frequência
        for(int index = leftIndex; index <= rightIndex; index++) {
            frequencia[array[index] - menor] += 1;
        }

        // Ordena
        int indiceArray = rightIndex;
        for(int index = tamanhoArray - 1; index >= 0; index--) {
            if(frequencia[index] == 0) continue;
            int element = index + menor;
            int vezes = frequencia[index];
            for(int vez = 0; vez < vezes; vez++) {
                array[indiceArray] = element;
                indiceArray--;
            }
        }
	}

    private Integer[] encontraMaiorEMenor(Integer[] array, int leftIndex, int rightIndex) {
        Integer menor = array[leftIndex];
        Integer maior = array[leftIndex];
        for(int index = leftIndex + 1; index <= rightIndex; index++) {
            if(array[index] < menor)
                menor = array[index];
            else if(array[index] > maior)
                maior = array[index];
        }
        return new Integer[] {menor, maior};
    }

}
