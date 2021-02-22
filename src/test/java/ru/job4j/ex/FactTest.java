package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calcThenMinus10() {
        new Fact().calc(-10);
    }

    @Test
    public void calcThen10() {
        assertThat(new Fact().calc(10), is(3628800));
    }
}