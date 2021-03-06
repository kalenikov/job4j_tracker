package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.collection.Parentheses;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParenthesesTest {

    @Test
    public void whenValidInner() {
        assertThat(
                Parentheses.valid(new char[] {'(', '(', ')', ')'}),
                is(true)
        );
    }

    @Test
    public void whenValidSeq() {
        assertThat(
                Parentheses.valid(new char[] {'(', ')', '(', ')'}),
                is(true)
        );
    }

    @Test
    public void whenInValidInner() {
        assertThat(
                Parentheses.valid(new char[] {')', ')', '(', '('}),
                is(false)
        );
    }

    @Test
    public void whenInValidSeq() {
        assertThat(
                Parentheses.valid(new char[] {'(', ')', '(', '('}),
                is(false)
        );
    }
}