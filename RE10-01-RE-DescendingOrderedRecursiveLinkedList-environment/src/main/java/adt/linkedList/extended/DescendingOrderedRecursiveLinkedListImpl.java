package adt.linkedList.extended;

import java.util.Comparator;

import adt.linkedList.LinkedList;
import adt.linkedList.RecursiveSingleLinkedListImpl;

/**
 * This class is an implementation of an ordered recursive single linked list
 * that behaves like a Set (it cannot contain repeated elements). The constraint
 * of this list is that the elements MUST be ordered in descending order. Tip:
 * think about if it is necessary to override insert, search and remove to use
 * the comparator and respect the constraint.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class DescendingOrderedRecursiveLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> {

	private Comparator<T> comparator;

	public DescendingOrderedRecursiveLinkedListImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

    @Override
    public void insert(T element) {
        if(isEmpty()) {
            setData(element);
            setNext(new DescendingOrderedRecursiveLinkedListImpl<T>());
        }
        // TODO: Terminar aqui
    }

	/**
	 * It returns the maximum element of the list or null if the list is empty.
	 * 
	 * @return
	 */
	public T maximum() {
	    return getData();	
	}

	/**
	 * It puts all elements of otherList in this list. Try to make this methods
	 * as fast as possible.
	 * 
	 * @param otherList
	 */
	public void insertAll(LinkedList<T> otherList) {
	    T[] elements = otherList.toArray((T[]) new Object[otherList.size()]); // O(n)
        sort(elements); // O(n * log n)
        for(T element : elements) { // O(n)
            insert(element);
        }
	}

    // Verificar esse método no papel
    private void sort(T[] array, int start, int end) {
        if(start >= end)
            return;
        int middle = (start + end) / 2;
        sort(array, start, middle);
        sort(array, middle + 1, end);
        merge(array, start, end);
    }

    private void merge(array, start, end) {
        T[] helper = Arrays.copyOfRange(array, start, end + 1);
        int iOriginal = 0;
        int iArray1= 0;
        int middleIndex = (start + end) / 2;
        int iArray2= middleIndex + 1;
        while(iArray1 <= middleIndex && iArray2 <= end) {
            if(this.comparator.compare(helper[iArray1], helper[iArray2]) >= 0) 
                array[iOriginal++] = helper[iArray1++];
            else
                array[iOriginal++] = helper[iArray2++];
        }

        while(iArray1 <= middleIndex) {
            array[iOriginal++] = helper[iArray1++];
        }
        
        while(iArray2 <= end) {
            array[iOriginal++] = helper[iArray2++];
        }
    }

	/**
	 * This methods compares (for set equality) this list with otherList
	 * (possibly containing repeated elements). This this method returns true if
	 * the lists have the same elements. It does not matter how many times they
	 * appear in otherList.
	 * 
	 * @param otherList
	 */
	public boolean equalsAsSet(LinkedList<T> otherList) {
		// TODO Implement your method here
		throw new UnsupportedOperationException("Not implemented!");
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

}
