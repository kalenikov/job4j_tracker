package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        SqlTracker tracker = SqlTracker.getInstance();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = SqlTracker.getInstance();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = SqlTracker.getInstance();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = SqlTracker.getInstance();
        Item item1 = new Item();
        item1.setName("test");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("test");
        tracker.add(item2);
        List<Item> rsl = tracker.findByName("test");
        List<Item> expected = List.of(item1, item2);
        assertEquals(rsl, expected);
    }
}