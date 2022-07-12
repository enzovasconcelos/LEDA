package adt.linkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SingleLinkedListImpl<Integer> lista = new SingleLinkedListImpl<>();
        lista.insert(12);
        lista.insert(7);
        lista.insert(9);
        System.out.println(Arrays.toString(lista.toArray()));
        System.out.println(lista.search(14));
        System.out.println(lista.search(12));
        System.out.println(lista.search(7));
        System.out.println(lista.search(9));
    }
}
