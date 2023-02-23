package adt.avltree;

import static adt.bt.Util.leftRotation;
import static adt.bt.Util.rightRotation;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	@Override
	public void insert(T element) {
		insert(element, getRoot());	
	}

	private void insert(T element, BSTNode<T> current) {
		if(current.isEmpty()) {
			current.setData(element);
			BSTNode<T> leftChild = new BSTNode<>();
			leftChild.setParent(current);
			BSTNode<T> rightChild = new BSTNode<>();
			rightChild.setParent(current);
			current.setLeft(leftChild);
			current.setRight(rightChild);
		}
		else if(element.compareTo(current.getData()) < 0)
			insert(element, (BSTNode<T>) current.getLeft());
		else 
			insert(element, (BSTNode<T>) current.getRight());
		
		rebalance(current);	
	}

	@Override
	public void remove(T element) {
		BSTNode<T> nodeToRemove = search(element);	
        if(nodeToRemove.isEmpty())
            return;
		if(this.root == nodeToRemove) {
			this.root = new BSTNode<T>();
			return;
		}
        if(nodeToRemove.isLeaf()) {
            BSTNode<T> parent = (BSTNode<T>) nodeToRemove.getParent();
            BSTNode<T> sentinela = new BSTNode<>();
            if(parent.getData().compareTo(nodeToRemove.getData()) < 0)
                parent.setRight(sentinela);
            else
                parent.setLeft(sentinela);
			rebalance(parent);
            return;
        }
        BSTNode<T> child = hasOnlyOneChild(nodeToRemove);
        if(child != null) {
           BSTNode<T> parent = (BSTNode<T>) nodeToRemove.getParent();
           if(parent.getData().compareTo(nodeToRemove.getData()) > 0)
               parent.setLeft(child);
           else
               parent.setRight(child);
			rebalance(parent);
        }
        else {
            BSTNode<T> sucessorNode = (BSTNode<T>) sucessor(nodeToRemove.getData());    
            nodeToRemove.setData(sucessorNode.getData());
			sucessorNode.setData(element);
            remove(element);
        }
	}

	private BSTNode<T> hasOnlyOneChild(BSTNode<T> node) {
        if(node.getLeft() != null && !node.getLeft().isEmpty()) {
            if(!node.getRight().isEmpty())
                return null;
            return (BSTNode<T>) node.getLeft();
        }
        if(node.getRight() != null && !node.getRight().isEmpty())
            return (BSTNode<T>) node.getRight();
        return null;
    }

	// AUXILIARY
	// protected int calculateBalance(BSTNode<T> node) {
	// 	if(node.isLeaf())
	// 		return 0;
			
	// 	BSTNode<T> left = (BSTNode<T>) node.getLeft();
	// 	BSTNode<T> right = (BSTNode<T>) node.getRight();
	// 	return 1 + calculateBalance(left) + calculateBalance(right);
	// }
	
	protected int calculateBalance(BSTNode<T> node) {
		BSTNode<T> left = (BSTNode<T>) node.getLeft();
		BSTNode<T> right = (BSTNode<T>) node.getRight();
		if (!node.isEmpty()) return height(left) - height(right);
    	return 0;	
	}

	private int height(BSTNode<T> node) {
	    if (node.isEmpty())
	        return -1;

		BSTNode<T> left = (BSTNode<T>) node.getLeft();
		BSTNode<T> right = (BSTNode<T>) node.getRight();
	    return 1 + Math.max(height(left), height(right));
	}	

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		if(balance > 1) {
			BSTNode<T> leftChild = (BSTNode<T>) node.getLeft();
			if(calculateBalance(leftChild) == -1)
				leftRotation(leftChild);
			BSTNode<T> newRoot = rightRotation(node);
			if(node == this.root)
				this.root = newRoot;
		}
		else if (balance < -1) {
			BSTNode<T> rightChild = (BSTNode<T>) node.getRight();
			if(calculateBalance(rightChild) == 1)
				rightRotation(rightChild);
			BSTNode<T> newRoot = leftRotation(node);
			if(node == this.root)
				this.root = newRoot;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
