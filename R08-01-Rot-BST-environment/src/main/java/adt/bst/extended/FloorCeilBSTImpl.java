package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
	    for(Integer elem : array) {
            this.insert(elem);
        }	
        return floor(this.getRoot(), numero, null);
	}

    private Integer floor(BSTNode<Integer> current, double numero, Integer result) {
        if(current.isEmpty())
            return result;
        Integer currentData = current.getData();
        if(currentData > result && currentData <= numero)
            result = currentData;
        BSTNode<Integer> leftChild = (BSTNode<Integer>) current.getLeft();
        BSTNode<Integer> rightChild = (BSTNode<Integer>) current.getRight();
        Integer resultLeft = floor(leftChild, numero, result);
        Integer resultRight = floor(rightChild, numero, result);
        result = resultLeft > result ? resultLeft : result; 
        result = resultRight > result ? resultRight : result; 
        return result;
    }

	@Override
	public Integer ceil(Integer[] array, double numero) {
	    for(Integer elem : array) {
            this.insert(elem);
        }	
        return ceil(this.getRoot(), numero, null);
	}

    private Integer ceil(BSTNode<Integer> current, double numero, Integer result) {
        if(current.isEmpty())
            return result;
        Integer currentData = current.getData();
        if(currentData < result && currentData >= numero)
            result = currentData;
        BSTNode<Integer> leftChild = (BSTNode<Integer>) current.getLeft();
        BSTNode<Integer> rightChild = (BSTNode<Integer>) current.getRight();
        Integer resultLeft = floor(leftChild, numero, result);
        Integer resultRight = floor(rightChild, numero, result);
        result = resultLeft < result ? resultLeft : result; 
        result = resultRight < result ? resultRight : result; 
        return result;
    }

}
