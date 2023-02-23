package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		return isBST() && isAVLTree(getAVLTree().getRoot());
	}

	private boolean isAVLTree(BSTNode<T> current) {
		if(current.isEmpty())
			return true;
		if(getAVLTree().calculateBalance(current) > 1)
			return false;

		BSTNode<T> left = (BSTNode<T>) current.getLeft();
		BSTNode<T> right = (BSTNode<T>) current.getRight();
		return isAVLTree(left) && isAVLTree(right);
	}

}
