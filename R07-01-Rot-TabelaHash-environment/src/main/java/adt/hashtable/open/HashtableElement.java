package adt.hashtable.open;

public class HashtableElement implements Storable {

	private Integer key;

	public HashtableElement(int key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return this.key.hashCode();
	}

    // É interessante verificar a chave?
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

}
