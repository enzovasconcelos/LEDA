package adt.linkedList;

import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
	    return this.data == null;	
	}

	@Override
	public int size() {
	    if(isEmpty())
            return 0;
        return 1 + next.size();     
	}

	@Override
	public T search(T element) {
        if(isEmpty())
           return null;
        if(getData().equals(element))
           return getData(); 
        return getNext().search(element);
	}

	@Override
	public void insert(T element) {
	    if(isEmpty()) {
            setData(element);
            setNext(new RecursiveSingleLinkedListImpl<T>());
        } else {
            getNext().insert(element);
        }
	}

	@Override
	public void remove(T element) {
	    if(isEmpty())    
            return;
        if(getData().equals(element)) {
            if(getNext().isEmpty()) {
                setData(null);
                setNext(null);
                return;
            }
            else {
                setData(getNext().getData());
                getNext().setData(element);
            }
        } 
        getNext().remove(element);
	}

	@Override
	public T[] toArray() {
        ArrayList<T> list = new ArrayList<>();
        toArray(list); 
        return list.toArray((T[]) new Object[list.size()]);
	}

    private void toArray(ArrayList<T> list) {
        if(!isEmpty()) {
            list.add(this.data);
            this.next.toArray(list);
        }
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
