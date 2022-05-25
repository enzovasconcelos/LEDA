import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import vetor.Vetor;
import vetor.Aluno;

public class VetorTest {
    private Vetor vetor;

    @BeforeEach
    void instanciaVetor() {
        final int TAMANHO_VETOR = 4;
        this.vetor = new Vetor(TAMANHO_VETOR);
    }

    @Test
    void getMaximoDeVetorVazio() {
        assertEquals(this.vetor.getMaximo(), null);
    }

    @Test
    void getMaximoComUmAluno() {
        Aluno aluno = new Aluno("João", 8.0);
        this.vetor.inserir(aluno);
        assertEquals(this.vetor.getMaximo(), aluno);
    }

    // O algoritmo deve ser estável, retornando o primeiro
    // aluno inserido.
    @Test
    void getMaximoParaMediasIguais() {
        Aluno aluno1 = new Aluno("João", 8.0);
        Aluno aluno2 = new Aluno("Maria", 8.0);
        this.vetor.inserir(aluno1);
        this.vetor.inserir(aluno2);
        assertEquals(this.vetor.getMaximo(), aluno1);
    }

    @Test
    void getMaximo1() {
        Aluno aluno1 = new Aluno("João", 7.5);
        Aluno aluno2 = new Aluno("Maria", 7.0);
        this.vetor.inserir(aluno1);
        this.vetor.inserir(aluno2);
        assertEquals(this.vetor.getMaximo(), aluno1);
    }

    @Test
    void getMaximo2() {
        Aluno aluno1 = new Aluno("João", 7.0);
        Aluno aluno2 = new Aluno("Maria", 7.5);
        this.vetor.inserir(aluno1);
        this.vetor.inserir(aluno2);
        assertEquals(this.vetor.getMaximo(), aluno2);
    }

    @Test
    void getMinimo1() {
        Aluno aluno1 = new Aluno("João", 7.0);
        Aluno aluno2 = new Aluno("Maria", 7.5);
        this.vetor.inserir(aluno1);
        this.vetor.inserir(aluno2);
        assertEquals(this.vetor.getMaximo(), aluno1);
    }

    @Test
    void getMinimo2() {
        Aluno aluno1 = new Aluno("João", 7.5);
        Aluno aluno2 = new Aluno("Maria", 7.0);
        this.vetor.inserir(aluno1);
        this.vetor.inserir(aluno2);
        assertEquals(this.vetor.getMaximo(), aluno2);
    }

    @Test
    void inserirObjetoNaoAlunoTest() {
        String nome = "Guilherme";
        try {
            this.vetor.inserir(nome);
            fail("Deveria lançar exceção");
        } catch(RuntimeException e) {
            assertTrue(true);
        }
    }

    @Test
    void inserirObjetoAluno() {
       this.vetor.inserir(new Aluno("João", 10.0));  
    }

    @Test
    void removerObjetoQueNaoExiste() {
        Aluno a1 = new Aluno("Sandra", 9.6);
        assertEquals(this.vetor.remover(a1), null);
    }

    @Test
    void removerObjeto() {
        Aluno a1 = new Aluno("Emerson", 7.9);
        this.vetor.inserir(a1);
        assertEquals(this.vetor.tamanho(), 1);
        assertEquals(this.remover(a1), a1);
        assertEquals(this.vetor.tamanho(), 0);
    }

    @Test
    void procurarTest1() {
        Aluno aluno = new Aluno("Pedro", 8.0);
        assertEquals(this.vetor.procurar(aluno), null);
    }

    @Test
    void procurarTest2() {
        Aluno aluno = new Aluno("Pedro", 8.0);
        this.vetor.inserir(aluno);
        assertEquals(this.vetor.procurar(aluno), aluno);
    }

    @Test
    void isVazioTest1() {
        assertTrue(this.vetor.isVazio());
    }

    @Test
    void isVazioTest2() {
        this.vetor.inserir(new Aluno("João", 7.5));
        assertFalse(this.vetor.isVazio());
    }

    @Test
    void isCheioTest1() {
        Aluno aluno = new Aluno("João", 7.9);
        this.vetor.inserir(aluno);
        this.vetor.inserir(aluno);
        this.vetor.inserir(aluno);
        assertFalse(this.vetor.isCheio());
    }

    @Test
    void isCheioTest2() {
        Aluno aluno = new Aluno("João", 7.9);
        this.vetor.inserir(aluno);
        this.vetor.inserir(aluno);
        this.vetor.inserir(aluno);
        this.vetor.inserir(aluno);
        assertTrue(this.vetor.isCheio());
    }
}
