package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
	    return equals(tree1, tree2, tree1.getRoot(), tree2.getRoot());	
	}

    private boolean equals(BST<T> tree1, BST<T> tree2, 
            BTNode<T> node1, BTNode<T> node2) {
        if(!node1.equals(node2))
            return false;
        if(node1.isEmpty())
            return true;
        else {
            boolean result = equals(tree1, tree2, node1.getLeft(), 
                    node2.getLeft());
            if(result == false)
                return false;
            result = equals(tree1, tree2, node1.getRight(), 
                    node2.getRight());
            return result;
        }
    }

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
	    return isSimilar(tree1, tree2, tree1.getRoot(), tree2.getRoot());	
	}

    private boolean isSimilar(BST<T> tree1, BST<T> tree2, 
            BTNode<T> node1, BTNode<T> node2) {
        if(node1.isEmpty()) {
            return node2.isEmpty();
        }
        if(numberOfChilds(node1) != numberOfChilds(node2))
            return false;
        boolean result = isSimilar(tree1, tree2, node1.getLeft(), 
                node2.getLeft());
        if(result == false)
            return result;
        return isSimilar(tree1, tree2, node1.getRight(), 
                node2.getRight());
    }

    private int numberOfChilds(BTNode<T> node) {
        int numberChilds = 0;
        numberChilds += node.getLeft().isEmpty() ? 0 : 1;
        numberChilds += node.getRight().isEmpty() ? 0 : 1;
        return numberChilds;
    }

	@Override
	public T orderStatistic(BST<T> tree, int k) {
        if(k < 1)
            return null;            
        // TODO: terminar aqui
        // Testar se funciona:
        // 1. Pegar o mínimo
        // 2. Visitar o pai e a direita até o kAtual ser igual a k
        int kAtual = 1;
        return orderStatistic(tree.maximum(), tree.minimum(), kAtual, k);
	}

    private T orderStatistic(BSTNode<T> maximun, BSTNode<T> current, int kAtual, int k) {
        if(maximun == current)
            return null;
        if(kAtual == k)
            return current.getData();
        BSTNode<T> parent = (BSTNode<T>) current.getParent();
        T result = orderStatistic(maximun, parent, kAtual + 1, k);
        if(result != null)
            return result;
        BSTNode<T> right = (BSTNode<T>) parent.getRight();
        return orderStatistic(maximun, right, kAtual + 1, k);
    }

}
