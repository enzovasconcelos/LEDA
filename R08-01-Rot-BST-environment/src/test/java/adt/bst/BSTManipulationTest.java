package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTImpl;

public class BSTManipulationTest {

    private SimpleBSTManipulation<Integer> BSTManipulation;

    @Before
    public void setUp() {
        this.BSTManipulation = new SimpleBSTManipulationImpl<>();
    }

    @Test
    public void testEquals01() {
        BSTImpl<Integer> tree1 = new BSTImpl<>();
        BSTImpl<Integer> tree2 = new BSTImpl<>();
        assertTrue(BSTManipulation.equals(tree1, tree2));
    }

    @Test
    public void testEquals02() {
        BSTImpl<Integer> tree1 = new BSTImpl<>();
        BSTImpl<Integer> tree2 = new BSTImpl<>();
        tree1.insert(12);
        tree2.insert(23);
        assertFalse(BSTManipulation.equals(tree1, tree2));
    }

    @Test
    public void testEquals03() {
        BSTImpl<Integer> tree1 = new BSTImpl<>();
        BSTImpl<Integer> tree2 = new BSTImpl<>();
        tree1.insert(12);
        tree1.insert(23);
        tree2.insert(23);
        tree2.insert(12);
        assertFalse(BSTManipulation.equals(tree1, tree2));
    }

    // Árvores iguais, porém com ordens de inserção diferentes
    @Test
    public void testEquals04() {
        BSTImpl<Integer> tree1 = new BSTImpl<>();
        BSTImpl<Integer> tree2 = new BSTImpl<>();
        tree1.insert(12);
        tree1.insert(23);
        tree1.insert(3);
        tree1.insert(7);
        tree1.insert(15);
        tree1.insert(27);
        tree2.insert(12);
        tree2.insert(3);
        tree2.insert(23);
        tree2.insert(27);
        tree2.insert(15);
        tree2.insert(7);
        assertTrue(BSTManipulation.equals(tree1, tree2));
    }

    @Test
    public void testSimilar01() {
        BSTImpl<Integer> tree1 = new BSTImpl<>();
        BSTImpl<Integer> tree2 = new BSTImpl<>();
        assertTrue(BSTManipulation.isSimilar(tree1, tree2));
    }

    @Test
    public void testSimilar02() {
        BSTImpl<Integer> tree1 = new BSTImpl<>();
        BSTImpl<Integer> tree2 = new BSTImpl<>();
        tree1.insert(12);
        tree1.insert(23);
        tree1.insert(3);
        tree1.insert(7);
        tree1.insert(15);
        tree1.insert(27);
        tree2.insert(40);
        tree2.insert(50);
        tree2.insert(23);
        tree2.insert(35);
        tree2.insert(45);
        tree2.insert(55);
        assertTrue(BSTManipulation.isSimilar(tree1, tree2));
    }

    @Test
    public void testSimilar03() {
        BSTImpl<Integer> tree1 = new BSTImpl<>();
        BSTImpl<Integer> tree2 = new BSTImpl<>();
        tree1.insert(12);
        tree1.insert(23);
        tree1.insert(3);
        tree1.insert(7);
        tree1.insert(15);
        tree1.insert(27);
        tree2.insert(40);
        tree2.insert(50);
        tree2.insert(23);
        tree2.insert(35);
        tree2.insert(45);
        tree2.insert(47);
        assertFalse(BSTManipulation.isSimilar(tree1, tree2));
    }
    
    @Test
    public void testOrderStatistic01() {
        BSTImpl<Integer> tree1 = new BSTImpl<>();
        tree1.insert(12);
        tree1.insert(23);
        tree1.insert(3);
        tree1.insert(7);
        tree1.insert(15);
        tree1.insert(27);
        assertEquals(BSTManipulation.orderStatistic(tree1, 1), new Integer(7));
        assertEquals(BSTManipulation.orderStatistic(tree1, 6), new Integer(27));
        assertEquals(BSTManipulation.orderStatistic(tree1, 3), new Integer(12));
        assertEquals(BSTManipulation.orderStatistic(tree1, 5), new Integer(23));
        assertEquals(BSTManipulation.orderStatistic(tree1, 0), null);
        assertEquals(BSTManipulation.orderStatistic(tree1, 7), null);
    }

}
