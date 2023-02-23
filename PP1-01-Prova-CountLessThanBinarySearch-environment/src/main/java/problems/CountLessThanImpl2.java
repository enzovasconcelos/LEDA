package problems;

public class CountLessThanImpl2 implements CountLessThan{

    @Override
	public int countLess(Integer[] array, Integer x){
        return busca(array, x, 0, array.length - 1);
    }
    
    private static int busca(Integer[] array, Integer x, int left, int right) {
        if(left > right)
            return 0;
        int numMenores = 0;
        int middle = (left + right) / 2;
        if(array[middle] >= x)
            numMenores = busca(array, x, left, middle - 1);
        else
            numMenores = Math.max(middle + 1, busca(array, x, middle + 1, right));
        return numMenores;
    }
}
