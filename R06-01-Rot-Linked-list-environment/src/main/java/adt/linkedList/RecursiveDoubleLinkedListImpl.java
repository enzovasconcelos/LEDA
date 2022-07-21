package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}
    
    @Override
	public void insert(T element) {
	    if(isEmpty()) {
            setData(element);
            setNext(new RecursiveDoubleLinkedListImpl<T>());
        } 
        else 
            getNext().insert(element);
	}

	@Override
    public void insertFirst(T element) {
        if(isEmpty()) {
            setData(element);
            setNext(new RecursiveDoubleLinkedListImpl<T>());
        }
        else {
            T aux = getData();
            setData(element);
            ((RecursiveDoubleLinkedListImpl<T>) getNext()).insertFirst(aux);
        }
    }

	@Override
	public void removeFirst() {
        remove(getData());   
	}

	@Override
	public void removeLast() {
	    if(!isEmpty()) {
            if(getNext().isEmpty()) {
                setNext(null);
                setData(null);
            } 
            else
                ((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
        }	
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
