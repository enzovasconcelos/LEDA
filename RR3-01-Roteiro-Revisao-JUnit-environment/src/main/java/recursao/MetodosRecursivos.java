package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
	        return calcularSomaArrayAux(array, 0);	
	}

        private int calcularSomaArrayAux(int[] array, int indice) {
                if(indice >= array.length)
                    return 0;
                return array[indice] + calcularSomaArrayAux(array, indice + 1);
        }

	public long calcularFatorial(int n) {
	        long result = calcularFatorial2(n);	
                System.out.println(n + "! = " + result);
                return result;
	}

        private long calcularFatorial2(int n) {
                long result = 1;
                if(n == 0) {
                    return result;
                } 
        	return n * calcularFatorial(n - 1);
        }

        // TODO: Imprimir sequência.
	public int calcularFibonacci(int n) {
		if(n == 1 || n == 2)
                    return 1;
                return calcularFibonacci(n - 1) + calcularFibonacci(n - 2); 
	}

        public int countNotNull(Object[] array) {
	        return countNotNullAux(array, 0);	
	}

        private int countNotNullAux(Object[] array, int indice) {
            if(indice >= array.length)
                return 0;
            int numNulosAtual = 0;
            if(array[indice] != null)
                numNulosAtual = 1;
            return numNulosAtual + countNotNullAux(array, indice + 1);
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
