package adt.heap.extended;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FloorCeilTest {
    
    private FloorCeilHeap implementation;

    @Before
    public void setUp() {
        this.implementation = new FloorCeilHeapImpl((Integer e1, Integer e2) -> {
            return e1.compareTo(e2);
        });
    }

    @Test
    public void testFloor() {
        Integer[] array = {12, 5, 48, 14, 7};
        assertEquals(this.implementation.floor(array, 50), new Integer(48));
        assertEquals(this.implementation.floor(array, 5), new Integer(5));
        assertEquals(this.implementation.floor(array, 100), new Integer(48));
    }

    @Test
    public void testFloorInexistent() {
        Integer[] array = {12, 5, 48, 14, 7};
        assertEquals(this.implementation.floor(array, 4), null);
    }

    @Test
    public void testCeils() {
        Integer[] array = {12, 5, 48, 14, 7};
        assertEquals(this.implementation.ceil(array, 50), null);
        assertEquals(this.implementation.ceil(array, 5), new Integer(5));
        assertEquals(this.implementation.ceil(array, 13), new Integer(14));
        assertEquals(this.implementation.ceil(array, 40), new Integer(48));
    }
    
}
