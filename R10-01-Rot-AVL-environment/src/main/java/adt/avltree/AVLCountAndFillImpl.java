package adt.avltree;

import static adt.bt.Util.leftRotation;
import static adt.bt.Util.rightRotation;
import java.util.Arrays;
import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		if(balance > 1) {
			BSTNode<T> leftChild = (BSTNode<T>) node.getLeft();
			if(calculateBalance(leftChild) == -1) {
				this.LRcounter++;
				leftRotation(leftChild);
			}
			else
				this.LLcounter++;
			BSTNode<T> newRoot = rightRotation(node);
			if(node == this.root)
				this.root = newRoot;
		}
		else if (balance < -1) {
			BSTNode<T> rightChild = (BSTNode<T>) node.getRight();
			if(calculateBalance(rightChild) == 1) {
				rightRotation(rightChild);
				this.RLcounter++;
			}
			else
				this.RRcounter++;
			BSTNode<T> newRoot = leftRotation(node);
			if(node == this.root)
				this.root = newRoot;
		}
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		Arrays.sort(array);	
		fillWithoutRebalance(array, 0, array.length - 1);
	}

	private void fillWithoutRebalance(T[] array, int left, int right) {
		int middle = (left + right) / 2;
		insert(array[middle]);
		fillWithoutRebalance(array, left, middle);
		fillWithoutRebalance(array, middle + 1, right);
	}

}
