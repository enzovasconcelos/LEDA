package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
	    for(Integer number : array) {
            this.insert(number);
        }	

        Integer floor = null;
        Integer numeroInteger = (int) numero;
        Comparator<Integer> comparator = getComparator();
        while(!isEmpty()) {
            Integer root = extractRootElement();
            if(comparator.compare(root, numeroInteger) < 0) {
                if(floor == null || comparator.compare(root, floor) > 0)
                    floor = root;
            }
            else if(comparator.compare(root, numeroInteger) == 0) {
                floor = root;
                break;
            }
        }

        return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
	    for(Integer number : array) {
            this.insert(number);
        }	

        Integer ceil = null;
        Integer numeroInteger = (int) numero;
        Comparator<Integer> comparator = getComparator();
        while(!isEmpty()) {
            Integer root = extractRootElement();
            if(comparator.compare(root, numeroInteger) > 0) {
                if(ceil == null || comparator.compare(root, ceil) < 0)
                    ceil = root;
            }
        }

        return ceil;
	}

}
