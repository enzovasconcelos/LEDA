package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
        return this.head.isNIL();	    	
	}

	@Override
	public int size() {
	    int size = 0;
        SingleLinkedListNode<T> aux = this.head;      	
        while(!aux.isNIL()) {
            size++;
            aux = aux.getNext();
        }
        return size;
	}

	@Override
	public T search(T element) {
	    SingleLinkedListNode<T> aux = this.head;
        while(!aux.isNIL()) {
            if(aux.getData().equals(element))
                break;
            aux = aux.getNext();
        }
        return aux.getData();
	}

	@Override
	public void insert(T element) {
        if(element == null)
            return;
	    SingleLinkedListNode<T> aux = this.head;
        while(!aux.isNIL()) {
            aux = aux.getNext();
        }
        aux.setData(element);	
        aux.setNext(new SingleLinkedListNode<>());
	}

	@Override
	public void remove(T element) {
	    if(element.equals(this.head.getData())) 
            this.head = this.head.getNext();
        else {
            SingleLinkedListNode<T> aux = this.head;
            if(aux.isNIL()) return;
            while(!aux.getNext().isNIL()) {
                if(aux.getNext().getData().equals(element)) {
                    SingleLinkedListNode<T> next = aux.getNext();
                    aux.setNext(next.getNext());
                    break;
                }
                aux = aux.getNext();
            }
        }	
	}

	@Override
	public T[] toArray() {
        int size = size();
        T[] array = (T[]) new Comparable[size];
        SingleLinkedListNode<T> aux = this.head;
        for(int index = 0; index < size; index++) {
            array[index] = aux.getData();
            aux = aux.getNext();
        }
        return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
