package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BSTNode<T> current) {
        if(current.isEmpty())
            return -1;

        BSTNode<T> leftChild = (BSTNode<T>) current.getLeft();
        BSTNode<T> rightChild = (BSTNode<T>) current.getRight();
        return 1 + Math.max(height(leftChild), height(rightChild));
    }

	@Override
	public BSTNode<T> search(T element) {
	    if(isEmpty())
            return null;
        return search(element, (BSTNode<T>) this.root);    
	}

    private BSTNode<T> search(T element, BSTNode<T> current) {
        BSTNode<T> nextNode = null;
        if(element.compareTo(current.getData()) < 0)
            nextNode = (BSTNode<T>) current.getLeft(); 
        else 
            nextNode = (BSTNode<T>) current.getRight();

        if(nextNode.isEmpty())
            return new BSTNode<T>();
        else if(nextNode.getData().equals(element))
            return nextNode;
        else 
            return search(element, nextNode);
    }

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> maximum() {
	    if(isEmpty())        
            return null;
        return maximum((BSTNode<T>) (BSTNode<T>) this.root);
	}

    private BSTNode<T> maximum(BSTNode<T> current) {
        while(!current.getRight().isEmpty()) {
            current = (BSTNode<T>) current.getRight();
        }
        return current;
    }

	@Override
	public BSTNode<T> minimum() {
	    if(isEmpty())        
            return null;
        return minimum((BSTNode<T>) this.root);
	}

    private BSTNode<T> minimum(BSTNode<T> current) {
        while(!current.getLeft().isEmpty()) {
            current = (BSTNode<T>) current.getLeft();
        }
        return current;
    }

	@Override
	public BSTNode<T> sucessor(T element) {
	    BSTNode<T> sucessorNode = search(element);
        // if(sucessorNode == null)
            // return null;
        if(sucessorNode.isEmpty())
            return null;
        if(!sucessorNode.getRight().isEmpty())
            return minimum((BSTNode<T>) sucessorNode.getRight());
        BSTNode<T> parent = (BSTNode<T>) sucessorNode.getParent();
        BSTNode<T> current = sucessorNode;
        while(parent != null) {
            if(parent.getLeft() == current)
                return parent;
            current = parent;
            parent = (BSTNode<T>) current.getParent();
        }
        if(current.getData().compareTo(sucessorNode.getData()) > 0)
            return current;
        else
            return null;
	}

    // Dúvida: o que acontece se o elemento não existe na BST?
	@Override
	public BSTNode<T> predecessor(T element) {
	    BSTNode<T> predecessorNode = search(element);
        if(predecessorNode.isEmpty())
            return null;
        if(!predecessorNode.getLeft().isEmpty())
            return maximum((BSTNode<T>) predecessorNode.getLeft());
        BSTNode<T> parent = (BSTNode<T>) predecessorNode.getParent();
        BSTNode<T> current = predecessorNode;
        while(parent != null) {
            if(parent.getRight() == current)
                return parent;
            current = parent;
            parent = (BSTNode<T>) current.getParent();
        }
        if(current.getData().compareTo(predecessorNode.getData()) < 0)
            return current;
        else
            return null;
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
	    ArrayList<T> list = new ArrayList<>();
        preOrder(list, this.root);
        return (T[]) list.toArray(new Comparable[list.size()]);
	}

    private void preOrder(ArrayList<T> list, BSTNode<T> current) {
        if(!current.isEmpty()) {
            list.add(current.getData());
            preOrder(list, (BSTNode<T>) current.getLeft());
            preOrder(list, (BSTNode<T>) current.getRight());
        }
    }

	@Override
	public T[] order() {
	    ArrayList<T> list = new ArrayList<>();
        order(list, this.root);
        return (T[]) list.toArray(new Comparable[list.size()]);
	}

    private void order(ArrayList<T> list, BSTNode<T> current) {
        if(!current.isEmpty()) {
            order(list, (BSTNode<T>) current.getLeft());
            list.add(current.getData());
            order(list, (BSTNode<T>) current.getRight());
        }
    }

	@Override
	public T[] postOrder() {
	    ArrayList<T> list = new ArrayList<>();
        postOrder(list, this.root);
        return (T[]) list.toArray(new Comparable[list.size()]);    
	}

    private void postOrder(ArrayList<T> list, BSTNode<T> current) {
        if(!current.isEmpty()) {
            postOrder(list, (BSTNode<T>) current.getLeft());
            postOrder(list, (BSTNode<T>) current.getRight());
            list.add(current.getData());
        }
    }

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
