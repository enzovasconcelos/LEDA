package adt.linkedList;

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
	    int size = 0;
        if(getData() != null) {
            size = 1 + getNext().size();
        }   
        return size; 
	}

	@Override
	public T search(T element) {
        if(isEmpty())
            return null;
	    if(element.equals(getData()))	
            return element;
        else
            return getNext().search(element);
	}

	@Override
	public void insert(T element) {
	    if(element == null)
            return;

        if(isEmpty()) {
            setData(element);
            this.setNext(new RecursiveSingleLinkedListImpl<T>());
        }
        else
            this.getNext().insert(element);
	}

	@Override
	public void remove2(T element) {
	    if(isEmpty())
            return;
        if(getData().equals(element) && getNext().isEmpty()) {
            setData(null);
            setNext(null);
        }
        if(getData().equals(element)) {
            setData(getNext().getData());
            getNext().setData(element);
        }
        getNext().remove(element);
	}
    
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
        if(getNext().getData().equals(element)) {
            setNext(getNext().getNext());
            return;
        }
        getNext().remove(element);
    }

	@Override
	public T[] toArray() {
	    ArrayList<T> list = new ArrayList<>();
        addToList(list);
        return list.toArray((T[]) new Object[list.size()]);    
	}

    private addToList(ArrayList<T> list) {
        if(!isEmpty()) {
            list.add(getData());
            getNext().addToList(list);
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
