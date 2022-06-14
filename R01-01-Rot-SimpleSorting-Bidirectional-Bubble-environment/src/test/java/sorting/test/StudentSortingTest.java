package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;

import sorting.simpleSorting.*;
import sorting.variationsOfBubblesort.*;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new BidirectionalBubbleSort<>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

    /**
     * Verifica se o método sort não faz nada quando os índices
     * estão fora dos limites do array
     */
    public void testIndiceForaDosLimites(Integer[] array) {
        Integer[] estadoOriginal = Arrays.copyOf(array, array.length);
        this.implementation.sort(array, 0, array.length);
        this.implementation.sort(array, -1, array.length - 1);
        // Não deve ter modificado o array
        Assert.assertArrayEquals(estadoOriginal, array);
    }

    @Test
    public void testForaLimite1() {
        testIndiceForaDosLimites(this.vetorTamPar);
    }

    @Test
    public void testForaLimite2() {
        testIndiceForaDosLimites(this.vetorTamImpar);
    }

    @Test
    public void testForaLimite3() {
        testIndiceForaDosLimites(this.vetorValoresIguais);
    }

    /**
     * Verifica se o método ordena em um determinado pedaço do array
     * e mantém os índices do começo e do final sem alterações
     */
    @Test
    public void testPedacoArray() {
        Integer[] numeros = new Integer[] {12, 1, 5, 9, 6, 8, 4, 2, 0, 
            1, 2};
        Integer[] estadoFinal = new Integer[] {12, 1, 0, 2, 4, 5, 6, 
            8, 9, 1, 2}; 
        this.implementation.sort(numeros, 2, 8);
        Assert.assertArrayEquals(numeros, estadoFinal);
    }

    // public void testPedacoArrayGenerico(Integer[] numeros) {
    //     this.implementation.sort(numeros, 2, numeros.length - 3);

    //     Integer[] estadoFinal = new Integer[numeros.length];
    //     Integer[] meio = Arrays.copyOfRange(numeros, 2, numeros.length - 2);
    //     int indiceMeio = 0;
    //     for(int indice = 0; indice < numeros.length; indice++) {
    //         if(indice >= 2 && indice <= numeros.length - 3) {
    //             estadoFinal[indice] = meio[indiceMeio];
    //             indiceMeio++;
    //         } else {
    //             estadoFinal[indice] = numeros[indice];
    //         }
    //     }
    //     Assert.assertArrayEquals(numeros, estadoFinal);
    // }
}
