package dev.qinx.unionfind;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class QuickFindTest {

    @Test
    void basicTest() {

    }

    @Test
    void executionTimeTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        UnionFindTest.testExecutionTime(QuickFind.class);
    }
}
