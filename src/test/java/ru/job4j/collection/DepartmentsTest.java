package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortAsc() {
        List<String> input = Arrays.asList("a/c", "b/z", "a/b");
        List<String> expect = List.of("a/b", "a/c", "b/z");
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenFillAndSortAsc() {
        List<String> input = Arrays.asList("a/b/c", "a");
        List<String> expect = List.of("a", "a/b", "a/b/c");
        List<String> result = Departments.fillGaps(input);
        Departments.sortAsc(result);
        assertThat(result, is(expect));
    }

    @Test(expected = AssertionError.class)
    public void whenSortDesc() {
        List<String> input = Arrays.asList("a/b", "a/c", "b/y", "b/x");
        List<String> expect = List.of("b/x", "b/y", "a/b", "a/c");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }
}