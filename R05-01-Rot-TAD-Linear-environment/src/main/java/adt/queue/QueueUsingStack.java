package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;
    private int size;
    private int numberElements;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
        this.size = size;
        this.numberElements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
	    if(element != null) {
            if(isFull())
                throw new QueueOverflowException();
            try {
                this.stack1.push(element);
                this.numberElements++;
            } catch(StackOverflowException e) {
                e.printStackTrace();
            }
        }	
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
	    if(isEmpty())
            throw new QueueUnderflowException();
        
        try {
            if(this.stack2.isEmpty()) 
                transfere();
            T oldest = this.stack2.pop();
            this.numberElements--;
            return oldest;
        } catch(StackUnderflowException e) {
            e.printStackTrace();
        } 
        return null;
	}

    private void transfere() {
        try {
            while(!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
        } catch(StackOverflowException e) {
            e.printStackTrace();
        } catch(StackUnderflowException e) {
            e.printStackTrace();
        }
    }

	@Override
	public T head() {
        if(this.stack2.isEmpty())
            transfere();
	    return this.stack2.top();	
	}

	@Override
	public boolean isEmpty() {
	    return this.numberElements == 0;	
	}

	@Override
	public boolean isFull() {
	    return this.numberElements == this.size;	
	}

}
