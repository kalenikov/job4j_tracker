package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ArrayToListTest {
    @Test
    public void convert() {
        Integer[][] data = {{1, 2}, {3, 4}};
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(ArrayToList.convert(data), is(expected));
    }
}