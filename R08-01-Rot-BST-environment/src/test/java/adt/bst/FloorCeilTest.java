package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.bst.extended.FloorCeilBST;
import adt.bst.extended.FloorCeilBSTImpl;

public class FloorCeilTest {

    private FloorCeilBST implementation;

    @Before
    public void setUp() {
        this.implementation = new FloorCeilBSTImpl();
    } 

    @Test
    public void testFloor01() {
        Integer[] numeros = {3, 7, 12, 15, 23, 27};
        assertEquals(this.implementation.floor(numeros, 13), new Integer(12));
        assertEquals(this.implementation.floor(numeros, 2), null);
        assertEquals(this.implementation.floor(numeros, 27), new Integer(27));
        assertEquals(this.implementation.floor(numeros, 24), new Integer(23));
    }

    @Test
    public void testCeil01() {
        Integer[] numeros = {3, 7, 12, 15, 23, 27};
        assertEquals(this.implementation.floor(numeros, 13), new Integer(15));
        assertEquals(this.implementation.floor(numeros, 2), new Integer(3));
        assertEquals(this.implementation.floor(numeros, 27), new Integer(27));
        assertEquals(this.implementation.floor(numeros, 28), null);
        assertEquals(this.implementation.floor(numeros, 11), new Integer(12));
    }

}
