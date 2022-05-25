# Resposta do roteiro 1

- 1: Serve para definir um conceito no qual a classe que quiser 
fazer parte desse conceito deve implementar um conjunto de métodos.
Situações onde preciso lidar com objetos que possuam um método 
conhecido requerem o uso de interfaces. 

- 2:
```java
public interface Forma {
    public double calcularArea();
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Formas> formas = new ArrayList<>();
        for(Forma forma : formas) {
            System.out.println(forma.calcularArea());
        }
    }
}
```

- 4: 
    - Sim.
    - Sim.
    - Sim.


