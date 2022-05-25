package vetor;

import java.util.Comparator;
import java.lang.Comparable;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Aluno> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

        public T getMaximo() {
                T maior = this.arrayInterno[0];
                for(int indice = 1; indice < this.indice + 1; indice++) {
                    if(this.arrayInterno[indice].compareTo(maior) > 0)
                        maior = this.arrayInterno[indice];
                }
                return maior;
        }

        public T getMinimo() {
                T menor = this.arrayInterno[0];
                for(int indice = 1; indice < this.indice + 1; indice++) {
                    if(this.arrayInterno[indice].compareTo(menor) < 0)
                        menor = this.arrayInterno[indice];
                }
                return menor;
        }

	// Insere um objeto no vetor
	public void inserir(T o) {
	        this.arrayInterno[++this.indice] = o;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
                T removido = null;
	        for(int indice = 0; indice < this.indice + 1; indice++) {
                    if(!this.arrayInterno[indice].equals(o))
                        continue;
                    removido = this.arrayInterno[indice];
                    for(int atual = indice; atual < this.indice + 1; atual++) {
                        this.arrayInterno[atual] = this.arrayInterno[atual + 1];
                    }
                    this.indice--;
                    break;
                }
                return removido;
	}

	// Procura um elemento no vetor
	 public T procurar(T o) {
	        for(int indice = 0; indice < this.indice + 1; indice++) {
                    if(this.arrayInterno[indice].equals(o))
                        return this.arrayInterno[indice];
                }	
                return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
	        return this.indice == -1;	
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
	        return this.indice + 1 == this.tamanho;
	}

        public int tamanho() {
                return this.indice + 1;
        }

}

class Comparador<T extends Aluno> implements Comparator<T> {
    public int compare(T aluno1, T aluno2) {
        if(aluno1.getMedia() > aluno2.getMedia())
            return 1;
        else if(aluno1.getMedia() < aluno2.getMedia())
            return -1;
        else
            return 0;
    }
}
