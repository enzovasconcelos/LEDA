package problems;


import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class LinkedListPartitionImpl extends SingleLinkedListImpl<Integer> implements LinkedListPartition<Integer>{
    
    @Override
    public void partition(Integer valor) {
        SingleLinkedListNode<Integer> pivot = floor(valor); 
        Integer floor = pivot.getData();
        swap(pivot, head);
        SingleLinkedListNode<Integer> aux = head.getNext();
        SingleLinkedListNode<Integer> target = head.getNext();
        SingleLinkedListNode<Integer> lastTarget = head.getNext();
        while(!aux.isNIL()) {
            if(aux.getData() <= floor) {
                swap(aux, target);
                lastTarget = target;
                target = target.getNext();
            }
            aux = aux.getNext();
        }
        swap(head, lastTarget);
    }

    private void swap(SingleLinkedListNode<Integer> n1, SingleLinkedListNode<Integer> n2) {
        Integer aux = n1.getData();
        n1.setData(n2.getData());
        n2.setData(aux);
    }

    private SingleLinkedListNode<Integer> floor(Integer valor) {
        SingleLinkedListNode<Integer> aux = head;
        SingleLinkedListNode<Integer> pivot = aux;
        while(!aux.isNIL()) {
            if(aux.getData() > pivot.getData() && aux.getData() <= valor)
                pivot = aux;
            aux = aux.getNext();
        }
        return pivot;
    }

    // NAO MEXA EM NENHUM METODO ABAIXO. VOCE NAO PRECISA DE MAIS NADA PARA SUA IMPLEMENTACAO
    // ALEM DOS METODOS QUE ESTAO IMPLEMENTADOS. VOCE PRECISARA DO METODO INSERT APENAS 
    // PARA TESTAR SUA LISTA
    @Override
    public void insert(Integer element) {
        SingleLinkedListNode<Integer> auxHead = head;
		if(head.isNIL()){
			SingleLinkedListNode<Integer> newHead = new SingleLinkedListNode<Integer>(element,head);
			head = newHead;
		}else{
			while(!auxHead.getNext().isNIL()){
				auxHead = auxHead.getNext();
			}
			SingleLinkedListNode<Integer> newNode = new SingleLinkedListNode<Integer>(element,auxHead.getNext());
			auxHead.setNext(newNode);
		}
    }
}
