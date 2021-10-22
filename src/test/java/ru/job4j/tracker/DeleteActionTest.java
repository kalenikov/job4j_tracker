package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = MemTracker.getInstance();
        tracker.add(new Item("name1"));
        DeleteAction action = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(anyString())).thenReturn(1);
        action.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===="
                + ln + "The operation was successful" + ln));
        assertNull(tracker.findById(1));
    }
}