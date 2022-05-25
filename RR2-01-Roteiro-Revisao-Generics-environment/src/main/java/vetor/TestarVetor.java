package vetor;

public class TestarVetor {

	public static void main(String[] args) {
                // Preenchendo vetor com alunos
                Vetor<Aluno> alunos = new Vetor<>(20);
                Aluno aluno1 = new Aluno("João", 7.5);
                Aluno aluno2 = new Aluno("Maria", 7.0);
                Aluno aluno3 = new Aluno("Larissa", 9.0);
                Aluno aluno4 = new Aluno("Emerson", 1.0);
                alunos.inserir(aluno1);
                alunos.inserir(aluno2);
                alunos.inserir(aluno3);
                alunos.inserir(aluno4);

                // Testando getMaximo()
                Aluno maximo = alunos.getMaximo();
                assert maximo.equals(aluno3);

                // Testando getMinimo()
                Aluno minimo = alunos.getMinimo();
                assert minimo.equals(aluno4);

                // Testando comparador
                Comparador<Aluno> comparador = new Comparador<>();
                assert comparador.compare(aluno1, aluno2) == 1;
                assert comparador.compare(aluno2, aluno3) == -1;
                assert comparador.compare(aluno3, aluno4) == 1;
                assert comparador.compare(aluno1, aluno3) == -1;
                assert comparador.compare(aluno1, aluno4) == 1;
                assert comparador.compare(aluno2, aluno4) == -1;
	}
}
