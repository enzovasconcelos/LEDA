package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.lang.model.util.ElementScanner6;

import static util.Util.swap;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o menor sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 2 < 3),
 * essa heap deixa os elementos menores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. 
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma max-heap 
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é
	 * mudar apenas o comparator e mandar reordenar a heap usando esse
	 * comparator. Assim os metodos da heap não precisam saber se vai funcionar
	 * como max-heap ou min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma
	 * min-heap. OU seja, voce deve considerar que a heap usa o comparator
	 * interno e se o comparator responde compare(x,y) < 0 entao o x eh menor
	 * e sobe na heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (int i = 0; i <= this.index; i++) {
			resp.add(this.heap[i]);
		}
		return (T[])resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode
	 * ser a raiz da heap ou de uma sub-heap. O heapify deve usar o comparator
	 * para subir os elementos na heap.
	 */
	private void heapify(int position) {
	    while(position <= this.index) {
            if(endHeapify(position)) break;
            int left = left(position);
            int right = right(position);
            int smaller = smaller(position, left, right);
            swap(this.heap, position, smaller);
            position = smaller;
        }	
	}

    private boolean endHeapify(int position) {
        int left = left(position);
        int right = right(position);
        if(left > this.index || right > this.index)
            return true;

        Comparator<T> comparator = getComparator();     
        return (comparator.compare(this.heap[position], this.heap[right]) < 0 && 
                comparator.compare(this.heap[position], this.heap[left]) < 0);
    }

    private int smaller(int index1, int index2, int index3) {
        T element1 = this.heap[index1];
        T element2 = this.heap[index2];
        T element3 = this.heap[index3];
        Comparator<T> comparator = getComparator();
        if(comparator.compare(element1, element2) < 0) {
            if(comparator.compare(element1, element3) < 0) 
                return index1; 
            else
                return index3;
        } 
        else {
            if(comparator.compare(element2, element3) < 0) 
                return index2;
            else 
                return index3;
        }
    }

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		// /////////////////////////////////////////////////////////////////
        this.heap[++this.index] = element;
        int current = this.index;
        int parent = parent(current);
        Comparator<T> comparator = getComparator();
        while(current > 0 && comparator.compare(heap[current], heap[parent]) < 0) {
            swap(this.heap, current, parent);
            current = parent;
            parent = parent(current);
        }
	}

	@Override
	public void buildHeap(T[] array) {
	    this.heap = array;
        this.index = array.length - 1;
        for(int current = parent(this.index); current >= 0; current--) {
            heapify(current);
        }    
	}

	@Override
	public T extractRootElement() {
        if(isEmpty())
            return null;
        
	    T rootElement = this.heap[0];
        swap(this.heap, 0, this.index--);
        heapify(0);
        return rootElement;
	}

	@Override
	public T rootElement() {
	    return isEmpty() ? null : this.heap[0];	
	}

	// @Override
	// public T[] heapsort(T[] array) {
	//     for(T element : array) {
    //         this.insert(element);
    //     }

    //     ArrayList<T> ordered = new ArrayList<>();
    //     while(!isEmpty()) {
    //         ordered.add(extractRootElement());
    //     }
    //     return ordered.toArray((T[]) new Comparable[ordered.size()]);
	// }

	@Override
	public T[] heapsort(T[] array) {
		buildHeap(array);
		// Ordenando os nível		
		int start = 1;
		int end = start * 2;
		while(start <= this.index && end <= this.index) {
			sort(this.heap, start, end);
			start = end + 1;
			end = start * 2;
		}

		// Merging por nível
		int startLevel = 1;
		int level = 2;
		while(level <= this.index) {
			merge(this.heap, 0, startLevel, level);
			startLevel = level + 1;
			level = startLevel * 2; 
			if(level > startLevel)
				level = startLevel;
		}

		T[] ordered = Arrays.copyOf(this.heap, size());
		resetHeap();	
		return ordered;
	}

	private void sort(T[] array, int start, int end) {
		for(int i = start; i < end; i++) {
			int iSmallest = i;
			for(int j = i + 1; j <= end; j++) {
				if(array[j].compareTo(array[iSmallest]) < 0)
					iSmallest = j;
			}
			swap(array, iSmallest, i);
		}
	}

	private void merge(T[] array, int start, int middleIndex, int end) {
		T[] helper = Arrays.copyOfRange(array, start, end + 1); 
		int i = start;
		int j = middleIndex;
		int k = start;
		while(i < middleIndex && j <= end) {
			if(helper[i].compareTo(helper[j]) <= 0) 
				array[k++] = helper[i++];
			else
				array[k++] = helper[j++];
		}

		while(i < middleIndex) {
			array[k++] = helper[i++];
		}
		while(j <= end) {
			array[k++] = helper[j++];
		}
	}

	private void resetHeap() {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.index = -1;
	}

	@Override
	public int size() {
	    return this.index + 1;	
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
