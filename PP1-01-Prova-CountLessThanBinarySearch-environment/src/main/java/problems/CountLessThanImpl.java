package problems;

public class CountLessThanImpl implements CountLessThan{

    @Override
	public int countLess(Integer[] array, Integer x){
        final int NUM_MENORES = 0;
        return busca(array, x, 0, array.length - 1, NUM_MENORES);
    }

    private int busca(Integer[] array, Integer x, int leftIndex, int rightIndex, int numMenores) {
        if(leftIndex > rightIndex)
            return numMenores;
        int middleIndex = (leftIndex + rightIndex) / 2;
        if(array[middleIndex] == x || array[middleIndex] > x)
            return busca(array, x, leftIndex, middleIndex - 1, numMenores);
        else {
            numMenores = middleIndex + 1;
            return busca(array, x, middleIndex + 1, rightIndex, numMenores);
        }
    }

}
