package dev.qinx.unionfind;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class UnionFindTest {

    static <T extends UnionFind> void testExecutionTime(Class<T> cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        UnionFind uf = cls.getConstructor(Integer.TYPE).newInstance(15000);

        for (int i = 0; i < uf.length() - 1; i++) {
            //System.out.println(uf.debug());
            assertEquals(uf.length() - i, uf.count());
            assertFalse(uf.connected(i, i + 1));
            uf.union(i, i + 1);
            assertTrue(uf.connected(i, i + 1));
        }
    }
}
