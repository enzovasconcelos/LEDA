package recursao;

import java.util.Arrays;

public class TestarMetodosRecursivos {
	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe MetodosRecursivos.
                int numero = args.length > 0 ? Integer.parseInt(args[0]) : 5;
                MetodosRecursivos m = new MetodosRecursivos(); 
                m.calcularFibonacci(numero);
                m.calcularFatorial(numero);
                Object[] objects = new Object[] {"Oi", null, new Integer(120), null};
                System.out.println(Arrays.toString(objects));
                System.out.println(m.countNotNull(objects));
                System.out.println(m.potenciaDe2(0));
                System.out.println(m.potenciaDe2(1));
                System.out.println(m.potenciaDe2(2));
                System.out.println(m.potenciaDe2(3));
                int[] numeros = new int[] {5, 6, 10, 25, 89};
                System.out.println(m.calcularSomaArray(numeros));
	}
}
