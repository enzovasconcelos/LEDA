package recursao;

import java.util.ArrayList;
import java.util.Arrays;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
	    return soma(array, 0);	
	}

    private int soma(int[] array, int indice) {
        if(indice == array.length) 
            return 0;
        return array[indice] + soma(array, indice + 1);
    }

	public long calcularFatorial(int n) {
	    if(n == 0) {
                System.out.println("0! = 1");
                return 1;
            }
            long resultado = n * calcularFatorial(n - 1);
            System.out.println(n + "! = " + resultado);
            return resultado;
	}

    public int calcularFibonacci(int n) {
        int[] numeros = new int[n];
        numeros[0] = 1;
        numeros[1] = 1;
        this.fib(n, numeros);
        System.out.println(Arrays.toString(numeros));
        return numeros[n - 1];
    }

    private int fib(int n, int[] numeros) {
        if(n == 1 || n == 2)
            return 1;
        
        int numero = fib(n - 1, numeros) + fib(n - 2, numeros);
        numeros[n - 1] = numero;
        return numero;
    }

    public int countNotNull(Object[] array) {
       return count(array, 0); 
    }

    private int count(Object[] array, int index) {
        if(index == array.length)
            return 0;
        int valor = array[index] instanceof Object ? 1 : 0;
        return valor + count(array, index + 1);
    }

	public long potenciaDe2(int expoente) {
	    if(expoente == 0)
            return 1;
        if(expoente == 1)
            return 2;
        return 2 * potenciaDe2(expoente - 1);    
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
	    if(n == 1)
            return termoInicial;
        return razao + progressaoAritmetica(termoInicial, razao, n - 1);
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		if(n == 1)
            return termoInicial;
        return razao * progressaoAritmetica(termoInicial, razao, n - 1);
	}
	
	
}
