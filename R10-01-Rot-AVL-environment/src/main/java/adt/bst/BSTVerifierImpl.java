package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		BSTNode<T> root = getBSt().getRoot();
		if(root.isEmpty())
			return true;
		return isBST(getBSt().getRoot());
	}

	private boolean isBST(BSTNode<T> current) {
		BSTNode<T> left = (BSTNode<T>) current.getLeft();
		BSTNode<T> right = (BSTNode<T>) current.getRight();
		if(current.isEmpty())
			return true;
		if(!left.isEmpty() && left.getData().compareTo(current.getData()) > 0)
			return false;	
		if(right.isEmpty() && right.getData().compareTo(current.getData()) < 0)
			return false;
			
		return isBST(left) && isBST(right);
	}
	
}
