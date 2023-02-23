package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
        if(isFull())
            throw new HashtableOverflowException();
	    int probe = 0;
	    while(probe < this.table.length) {
            int hash = ((HashFunctionQuadraticProbing) hashFunction).hash(element, probe);
            if(this.table[hash] == null || this.table[hash].equals(deletedElement)) {
                this.table[hash] = element;
                this.elements++;
                break;
            }
            this.COLLISIONS++;
            probe++;
        }
	}

	@Override
	public void remove(T element) {
	    int probe = 0;
	    while(probe < this.table.length) {
            int hash = ((HashFunctionQuadraticProbing) hashFunction).hash(element, probe);
            if(this.table[hash] == null)
                break;
            if(this.table[hash].equals(element)) {
                this.table[hash] = deletedElement;
                this.elements--;
                break;
            }
            probe++;
        }
	}

	@Override
	public T search(T element) {
        int probe = 0;
	    while(probe < this.table.length) {
            int hash = ((HashFunctionQuadraticProbing) hashFunction).hash(element, probe);
            if(this.table[hash] == null)
                return null;
            if(this.table[hash].equals(element))
                return (T) this.table[hash];
            probe++;
        }	
        return null;
	}

	@Override
	public int indexOf(T element) {
	    int probe = 0;
	    while(probe < this.table.length) {
            int hash = ((HashFunctionQuadraticProbing) hashFunction).hash(element, probe);
            if(this.table[hash] == null)
                return -1;
            if(this.table[hash].equals(element))
                return hash;
            probe++;
        }
        return -1;
	}
}
