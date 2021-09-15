package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemByIdActionTest {

    @Before
    public void init() {
        MemTracker.getInstance().init();
    }

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = MemTracker.getInstance();
        tracker.add(new Item());
        FindItemByIdAction action = new FindItemByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(anyString())).thenReturn(1);
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by Id ===="
                + ln + "Item{id=1, name='null'}" + ln));
    }
}