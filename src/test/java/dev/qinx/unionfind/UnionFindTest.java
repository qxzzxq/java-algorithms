package dev.qinx.unionfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class UnionFindTest {

    <T extends UnionFind> void testExecutionTime(Class<T> cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        UnionFind uf = cls.getConstructor(Integer.TYPE).newInstance(20000);

        for (int i = 0; i < uf.length() - 1; i++) {
            //System.out.println(uf.debug());
            assertEquals(uf.length() - i, uf.count());
            assertFalse(uf.connected(i, i + 1));
            uf.union(i, i + 1);
            assertTrue(uf.connected(i, i + 1));
        }
    }

    @DisplayName("QuickFind")
    @Test
    void testQuickFind() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        testExecutionTime(QuickFind.class);
    }

    @DisplayName("QuickUnion")
    @Test
    void testQuickUnion() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        QuickUnion uf = new QuickUnion(10);
        uf.union(4, 3);
        assertEquals(uf.debug(), "[0, 1, 2, 3, 3, 5, 6, 7, 8, 9]");
        uf.union(3, 8);
        assertEquals(uf.debug(), "[0, 1, 2, 8, 3, 5, 6, 7, 8, 9]");
        uf.union(6, 5);
        assertEquals(uf.debug(), "[0, 1, 2, 8, 3, 5, 5, 7, 8, 9]");
        uf.union(9, 4);
        assertEquals(uf.debug(), "[0, 1, 2, 8, 3, 5, 5, 7, 8, 8]");
        uf.union(2, 1);
        assertEquals(uf.debug(), "[0, 1, 1, 8, 3, 5, 5, 7, 8, 8]");
        assertTrue(uf.connected(8, 9));
        assertFalse(uf.connected(5, 4));
        uf.union(5, 0);
        assertEquals(uf.debug(), "[0, 1, 1, 8, 3, 0, 5, 7, 8, 8]");
        uf.union(7, 2);
        assertEquals(uf.debug(), "[0, 1, 1, 8, 3, 0, 5, 1, 8, 8]");
        assertEquals(3, uf.count());
        uf.union(6, 1);
        assertEquals(uf.debug(), "[1, 1, 1, 8, 3, 0, 5, 1, 8, 8]");
        uf.union(7, 3);
        assertEquals(uf.debug(), "[1, 8, 1, 8, 3, 0, 5, 1, 8, 8]");
        assertEquals(1, uf.count());

        testExecutionTime(QuickUnion.class);
    }
}
