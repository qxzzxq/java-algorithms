package dev.qinx.unionfind;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickUnionTest {

    @Test
    void basicTest() {
        QuickUnion uf = new QuickUnion(10);
        uf.union(4, 3);
        assertEquals(uf.toString(), "[0, 1, 2, 3, 3, 5, 6, 7, 8, 9]");
        uf.union(3, 8);
        assertEquals(uf.toString(), "[0, 1, 2, 8, 3, 5, 6, 7, 8, 9]");
        uf.union(6, 5);
        assertEquals(uf.toString(), "[0, 1, 2, 8, 3, 5, 5, 7, 8, 9]");
        uf.union(9, 4);
        assertEquals(uf.toString(), "[0, 1, 2, 8, 3, 5, 5, 7, 8, 8]");
        uf.union(2, 1);
        assertEquals(uf.toString(), "[0, 1, 1, 8, 3, 5, 5, 7, 8, 8]");
        assertTrue(uf.connected(8, 9));
        assertFalse(uf.connected(5, 4));
        uf.union(5, 0);
        assertEquals(uf.toString(), "[0, 1, 1, 8, 3, 0, 5, 7, 8, 8]");
        uf.union(7, 2);
        assertEquals(uf.toString(), "[0, 1, 1, 8, 3, 0, 5, 1, 8, 8]");
        assertEquals(3, uf.count());
        uf.union(6, 1);
        assertEquals(uf.toString(), "[1, 1, 1, 8, 3, 0, 5, 1, 8, 8]");
        uf.union(7, 3);
        assertEquals(uf.toString(), "[1, 8, 1, 8, 3, 0, 5, 1, 8, 8]");
        assertEquals(1, uf.count());
    }

    @Test
    void executionTimeTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        UnionFindTest.testExecutionTime(QuickUnion.class);
    }
}
