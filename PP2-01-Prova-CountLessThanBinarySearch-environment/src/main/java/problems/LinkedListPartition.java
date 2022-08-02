package problems;

import adt.linkedList.LinkedList;

/**
 * Interface que representa uma lista ligada contendo um metodo 
 * que cria uma particao na lista.
 */
public interface LinkedListPartition<T extends Comparable<T>> extends LinkedList<T>{
    
    /**
     * Dado um valor como parametro, possivelmente nao pertencendo a lista, o metodo 
     * aplica o particionamento da lista seguindo a mesma ideia do partition do quicksort, 
     * onde a esquerda do valor tem-se os elementos menores do que o valor, e 
     * a direita tem-se os elementos maiores do que o valor
     * 
     * Restricoes:
     * - Voce consegue resolver este problema epans com nocoes de iteracao sobre a lista
     *   e manipulacao de apontadores.
     * - Seu uso de memoria extra deve ser O(1) - NAO pode usar estrutura auxiliar alem 
     *   de variaveis simples.
     * - Seu algoritmo DEVE ter performance O(n)
     * - Voce NAO pode usar nenhum outro metodo pronto da classe lista na implementacao
     *   deste metodo, nem implementar a mesma logica de nenhum outro metodo de lista.
     * - Voce pode usar os metodos prontos da classe SingleLinkedListNode mas NAO pode altera-la.
     *   A unica classe que voce pode alterar eh a LinkedListPartitionImpl.java
     * - Voce DEVE preservar a ordem relativa original dos elementos em cada uma das particoes.
     *   Por exemplo:
     *   Seja a lista: 1->4->3->2->5->2->NIL e valor = 3,
     *   Retornaria: 1->2->2->4->3->5->NIL
     * 
     * @param valor o valor a ser usado como pivot do particionamento. Pode ou nao pertencer a lista.
     */
    public void partition(T valor);
}
