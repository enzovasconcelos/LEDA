package produto;

public interface IRepositorio {
    /**
     * Recebe o código e diz se existe o produto
     * com esse código armazenado.
     * @param codigo O código do produto
     */
    public boolean existe(int codigo);

    /**
     * Insere um produto na coleção de produtos
     * @param produto O produto a ser inserido
     */
    public void inserir(Produto produto);

    /**
     * Atualiza um produto.
     * @produto Objeto do tipo produto contendo os
     * novos dados
     */
    public void atualizar(Produto produto);

    /**
     * Remove produto de determinado código
     * @param codigo Código do produto a ser removido
     */
    public void remover(int codigo);

    /**
     * Retorna um determinado produto
     * @param codigo Código do produto que se quer retornar
     */
    public Produto procurar(int codigo);
}
