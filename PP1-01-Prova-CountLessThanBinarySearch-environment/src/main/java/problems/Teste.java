public class Teste {
    public static void main(String[] args) {
        Integer[] a1 = {3, 3, 3, 3, 3, 4}; 
        System.out.println(countLess(a1, 4) + " == 5");

        Integer[] a2 = {3, 3, 3, 3, 3, 3}; 
        System.out.println(countLess(a2, 3) + " == 0");

        Integer[] a3 = {1, 1, 3, 3, 3, 3}; 
        System.out.println(countLess(a3, 2) + " == 2");

        Integer[] a4 = new Integer[0]; 
        System.out.println(countLess(a4, 4) + " == 0");
    }

    private static int countLess(Integer[] array, int k) {
        return busca(array, k, 0, array.length - 1);
    }

    private static int busca(Integer[] array, int k, int left, int right) {
        if(left > right)
            return 0;
        int numMenores = 0;
        int middle = (left + right) / 2;
        if(array[middle] >= k)
            numMenores = busca(array, k, left, middle - 1);
        else
            numMenores = Math.max(middle + 1, busca(array, k, middle + 1, right));
        return numMenores;
    }
}
