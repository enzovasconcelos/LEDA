package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
	    if(isFull())
            throw new StackOverflowException();
        this.top.insert(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
	    if(isEmpty())
            throw new StackUnderflowException();
        DoubleLinkedListNode top = ((DoubleLinkedListImpl<T>) this.top).getLast();
        if(top == null)
            throw new StackUnderflowException();
        T topData = (T) top.getData();
        this.top.removeLast();    
        return topData;
	}

	@Override
	public T top() {
        DoubleLinkedListNode top = ((DoubleLinkedListImpl<T>) this.top).getLast();
	    return top == null ? null : (T) top.getData();	
	}

	@Override
	public boolean isEmpty() {
	    return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
	    return this.top.size() == this.size;	
	}

}
