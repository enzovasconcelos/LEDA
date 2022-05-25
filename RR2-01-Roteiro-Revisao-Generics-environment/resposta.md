# Resposta do roteiro

## Tipos genéricos em Java
- 1) Para permitir que a estrutura lide com qualquer tipo de objeto.

- 2)
```java 
public interface A<T> {
    public void m(T dado);
}
```

- 3)
```java 
public interface B extends A<String> {

}
```

- 4) Sim.
```java
public class C implements A<String> {
    public void m(String texto) {
        texto = new String(texto + "m");
    }
}
```

- 5) 
Esse método dessa classe recebe por parâmetro um objeto do tipo Collections. Esse objeto do tipo 
Collections é uma coleção que gerencia objetos de qualquer tipo.

- 6)
O método passa a aceitar uma coleção que armazena objetos de um tipo desconhecido para a classe do
método. Pode ser passado qualquer tipo por parâmetro.

- 7)
O método passa a aceitar por parâmetro um tipo desconhecido que herde do tipo no qual ela foi 
instaciada.

- 8)
O método passa a aceitar por parâmetro um tipo desconhecido no qual o tipo definido na instanciação
da classe herde dele.

## Qual coleção usar

- 1: 
    - Collection: Coleção de dados de tamanho não definido.
    - List: Coleção de dados. Lista de dados onde com ordem definida. Pode haver repetições.
    - Set: Conjunto matemático. Coleção de dados onde a ordem não importa e onde não são armazenados
           elementos repetidos.

- 2: 
    No caso geral é preferível a primeira forma (List<E> lista), porque só interessa ações que uma lista
    possui. É facilmente substituível a classe que implementa o conceito de lista.
