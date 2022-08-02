package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

    @Override
    public void insert(T element) {
        DoubleLinkedListNode<T> sentinela1 = new DoubleLinkedListNode<>();
        DoubleLinkedListNode<T> sentinela2 = new DoubleLinkedListNode<>();
        if(isEmpty()) {
            DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, sentinela1, sentinela2);
            this.head = newNode;
            this.last = newNode;
        } 
        else {
            DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, sentinela1, sentinela2);
            this.last.next = newNode;
            newNode.setPrevious(this.last);
            this.last = newNode;
        }
    }

	@Override
	public void insertFirst(T element) {
        DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) this.head;
	    DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, head, new DoubleLinkedListNode<T>());
        head.setPrevious(newNode);
        this.head = newNode;
	}

	@Override
	public void removeFirst() {
        if(isEmpty()) 
            return;
    	this.head = this.head.getNext();	
        DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) this.head;
        DoubleLinkedListNode<T> previous = null;
        if(size() > 1)
            previous = new DoubleLinkedListNode<>();
        head.setPrevious(previous);
	}

	@Override
	public void removeLast() {
	    if(isEmpty())
            return;
        this.last.getPrevious().setNext(this.last.getNext()); 
        this.last = this.last.getPrevious();
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
