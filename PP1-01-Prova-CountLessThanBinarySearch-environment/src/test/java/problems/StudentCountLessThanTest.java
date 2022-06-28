package problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentCountLessThanTest {

	private CountLessThanImpl implementation;
	
	@Before
	public void setUp() throws Exception {
		implementation = new CountLessThanImpl();
	}

	@Test
	public void testCountLessThanTC01() {
		Integer[] array = {2,3,4,5,6};
		int less = implementation.countLess(array,5);
		Assert.assertEquals(3,less);
	}

	@Test
	public void testCountLessThanTC02() {
		Integer[] array = {2,3,4,5,6};
		int less = implementation.countLess(array,2);
		Assert.assertEquals(0,less);
	}

    @Test
    public void test01() {
        Integer[] array = {3, 3, 3, 3, 3, 3};
        int less = implementation.countLess(array, 4);
		Assert.assertEquals(6, less);
    }

    @Test
    public void test02() {
        Integer[] array = {5, 6, 6, 8, 8, 10};
        int less = implementation.countLess(array, 7);
		Assert.assertEquals(3, less);
    }
    
    @Test
    public void test03() {
        Integer[] array = {5, 6, 7, 8, 8, 10};
        int less = implementation.countLess(array, 7);
		Assert.assertEquals(2, less);
    }

    @Test
    public void test04() {
        Integer[] array = {5, 6, 7, 8, 8, 10};
        int less = implementation.countLess(array, 4);
		Assert.assertEquals(0, less);
    }

    @Test
    public void test05() {
        Integer[] array = {5, 5, 5, 7, 8, 8, 10};
        int less = implementation.countLess(array, 6);
		Assert.assertEquals(3, less);
    }

    @Test
    public void test06() {
        Integer[] array = {5, 5, 5, 7, 8, 8, 10};
        int less = implementation.countLess(array, 11);
		Assert.assertEquals(7, less);
    }
}
