package dev.qinx.unionfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class UnionFindTest {

    <T extends UnionFind> void tester(Class<T> cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        UnionFind uf = cls.getConstructor(Integer.TYPE).newInstance(10);

        assertFalse(uf.connected(1, 2));
        uf.union(1, 2);
        assertTrue(uf.connected(1, 2));

        assertFalse(uf.connected(1, 3));
        uf.union(1, 3);
        assertTrue(uf.connected(1, 3));
        assertTrue(uf.connected(2, 3));

        assertEquals(8, uf.count());
    }

    @DisplayName("QuickFind")
    @Test
    void testQuickFind() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        tester(QuickFind.class);
    }
}
