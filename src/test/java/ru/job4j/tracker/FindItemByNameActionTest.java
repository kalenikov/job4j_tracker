package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemByNameActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = MemTracker.getInstance();
        tracker.add(new Item("name1"));
        FindItemByNameAction action = new FindItemByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(anyString())).thenReturn("name1");
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===="
                + ln + "Item{id=1, name='name1'}" + ln));
    }
}