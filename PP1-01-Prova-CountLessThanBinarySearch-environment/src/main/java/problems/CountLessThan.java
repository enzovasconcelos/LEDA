package problems;

/**
 * Dado um array A ordenado de inteiros de tamanho N e um valor x, usar busca binaria para 
 * encontrar o numero de elementos do array que sao menores do que x.
 *
 * Exemplo:
 *   A = [5, 7, 7, 8, 8, 10]
 *   x = 6
 *   Saida: 1 (apenas o 5 é menor que 6)
 *
 *   A = [5, 17, 100, 111]
     x = 3
 *   Saida: 0 (nao tem nenhum elemento do array menor que 3)
 *
 * Restricoes: 
 * - Seu algoritmo NÃO pode usar memória extra (a nao ser variaveis simples locais e nao de colecao/estrutura) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * - Voce DEVE usar busca binária com recursao
 *
 */
public interface CountLessThan {


	public int countLess(Integer[] array, Integer x);

}
