package orderStatistic;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class OrderStatisticTest {
    
    private OrderStatistics implementation;

    @Before
    void setUp() {
        this.implementation = new OrderStatisticsHeapImpl<>();
    }

    @Test
    void test01() {
        Integer[] array = {12, 5, 48, 14, 7};
        fail("Falta implementar o teste.");
    }
}
