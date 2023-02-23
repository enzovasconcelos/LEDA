package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		// Definir parent
		if(node.getParent() != null) 
			node.getParent().setRight(node.getRight());
		node.getRight().setParent(node.getParent());
		BSTNode<T> leftOfChild = (BSTNode<T>) node.getRight().getLeft();
		BSTNode<T> rightOfNode = (BSTNode<T>) node.getRight();
		rightOfNode.setLeft(node);
		node.setRight(leftOfChild);
		node.setParent(rightOfNode);		
		if(leftOfChild != null)
			leftOfChild.setParent(node);
		return rightOfNode;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		if(node.getParent() != null) 
			node.getParent().setLeft(node.getLeft());
		node.getLeft().setParent(node.getParent());
		BSTNode<T> rightOfChild = (BSTNode<T>) node.getLeft().getRight();	
		node.getLeft().setRight(node);
		node.setParent(node.getLeft());	
		node.setLeft(rightOfChild);
		if(rightOfChild != null)
			rightOfChild.setParent(node);
		return (BSTNode<T>) node.getParent();
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
