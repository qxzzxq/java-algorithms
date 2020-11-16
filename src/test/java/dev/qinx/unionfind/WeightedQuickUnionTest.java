package dev.qinx.unionfind;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightedQuickUnionTest {

    @Test
    void basicTest() {
        UnionFind uf = new WeightedQuickUnion(10);

        uf.union(4, 3);
        assertEquals(uf.toString(), "[0, 1, 2, 4, 4, 5, 6, 7, 8, 9]");

        uf.union(3, 8);
        assertEquals(uf.toString(), "[0, 1, 2, 4, 4, 5, 6, 7, 4, 9]");

        uf.union(6, 5);
        assertEquals(uf.toString(), "[0, 1, 2, 4, 4, 6, 6, 7, 4, 9]");

        uf.union(9, 4);
        assertEquals(uf.toString(), "[0, 1, 2, 4, 4, 6, 6, 7, 4, 4]");

        uf.union(2, 1);
        assertEquals(uf.toString(), "[0, 2, 2, 4, 4, 6, 6, 7, 4, 4]");
        assertTrue(uf.connected(8, 9));
        assertFalse(uf.connected(5, 4));

        uf.union(5, 0);
        assertEquals(uf.toString(), "[6, 2, 2, 4, 4, 6, 6, 7, 4, 4]");

        uf.union(7, 2);
        assertEquals(uf.toString(), "[6, 2, 2, 4, 4, 6, 6, 2, 4, 4]");
        assertEquals(3, uf.count());

        uf.union(6, 1);
        assertEquals(uf.toString(), "[6, 2, 6, 4, 4, 6, 6, 2, 4, 4]");

        uf.union(7, 3);
        assertEquals(uf.toString(), "[6, 2, 6, 4, 6, 6, 6, 6, 4, 4]");
        assertEquals(1, uf.count());
    }

    @Test
    void executionTimeTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        UnionFindTest.testExecutionTime(WeightedQuickUnion.class);
    }
}
