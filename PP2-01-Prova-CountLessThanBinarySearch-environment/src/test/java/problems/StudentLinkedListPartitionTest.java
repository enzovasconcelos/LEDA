package problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import adt.linkedList.SingleLinkedListNode;

public class StudentLinkedListPartitionTest {

	private LinkedListPartition<Integer> implementation;
	
	@Before
	public void setUp() throws Exception {
		implementation = new LinkedListPartitionImpl();
	}

	@Test
	public void testPartitionTC01() {
		Integer[] array = {8,2};
		for (Integer elem : array) {
			implementation.insert(elem);
		}
		implementation.partition(5);
		//verifica se o primeiro da lista modificada eh 2
		Assert.assertEquals((Integer) 2, ((LinkedListPartitionImpl) implementation).getHead().getData());
		//verifica se o segundo da lista modificada eh 8
		Assert.assertEquals((Integer) 8, ((LinkedListPartitionImpl) implementation).getHead().getNext().getData());
	}

    @Test
    public void test01() {
        Integer[] array = {1, 4, 3, 2, 5, 2};
        for (Integer elem : array) {
			implementation.insert(elem);
		}
        implementation.partition(3);
        Integer[] expected = {2, 1, 2, 3, 5, 4};
        SingleLinkedListNode<Integer> current = ((LinkedListPartitionImpl) implementation).getHead();
        for(Integer elem : expected) {
            Assert.assertEquals(elem, current.getData());
            current = current.getNext();
        }
    }

    //@Test
    //public void test02() {
        //Integer[] array = {9, 14, 3, 4, 10};
        //for (Integer elem : array) {
			//implementation.insert(elem);
		//}
        //implementation.partition(5);
        //Integer[] expected = {3, 4, 14, 9, 10};
        //SingleLinkedListNode<Integer> current = ((LinkedListPartitionImpl) implementation).getHead();
        //for(Integer elem : expected) {
            //Assert.assertEquals(elem, current.getData());
            //current = current.getNext();
        //}
    //}
}
