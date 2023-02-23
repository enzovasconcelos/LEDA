package orderStatistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class OrderStatisticTest {
    
    private OrderStatistics implementation;

    @Before
    public void setUp() {
        this.implementation = new OrderStatisticsHeapImpl<>();
    }

    @Test
    public void test01() {
        Integer[] array = {12, 5, 48, 14, 7};
        assertEquals(this.implementation.getOrderStatistics(array, 3), new Integer(12));
        assertEquals(this.implementation.getOrderStatistics(array, 1), new Integer(5));
        assertEquals(this.implementation.getOrderStatistics(array, 2), new Integer(7));
        assertEquals(this.implementation.getOrderStatistics(array, 5), new Integer(48));
        assertNull(this.implementation.getOrderStatistics(array, 6));
    }
    
}
