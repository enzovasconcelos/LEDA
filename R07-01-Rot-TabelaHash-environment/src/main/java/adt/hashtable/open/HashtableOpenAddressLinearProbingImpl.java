package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
        if(isFull())
            throw new HashtableOverflowException();
        int probe = 0;
	    while(probe < this.table.length) {
            int hash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, probe);
            T bucket = (T) this.table[hash];
            if(bucket == null || bucket.equals(deletedElement) ||
                    bucket.equals(element)) {
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
            int hash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, probe);
            if(this.table[hash] == null) break;
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
            int hash = ((HashFunctionLinearProbing) this.hashFunction).hash(element, probe);
            if(this.table[hash] == null) break;
            if(this.table[hash].equals(element)) {
               return (T) this.table[hash]; 
            }
            probe++;
        }
        return null;
	}

	@Override
	public int indexOf(T element) {
	    int probe = 0;
	    while(probe < this.table.length) {
            int index = ((HashFunctionLinearProbing) this.hashFunction).hash(element, probe);
            if(this.table[index].equals(element)) {
               return index; 
            }
            if(this.table[index] == null) break;
            probe++;
        }
        return -1;
	}
}
