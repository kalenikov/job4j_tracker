package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CollectToAnyMapTest {

    @Test
    public void testClassName() {
        List<Integer> data = List.of();
        String expectClass = "java.util.LinkedHashMap";
        String resultClass = CollectToAnyMap.collect(data.stream()).getClass().getName();
        assertEquals(expectClass, resultClass);
    }

}