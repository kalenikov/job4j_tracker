package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HbmTrackerTest {
    private final Store tracker = HbmTracker.getInstance();

    @Before
    public void before() {
        tracker.init();
    }

    @Test
    public void add() {
        Item item = new Item("item1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void replace() {
        Item item1 = new Item("Item1");
        tracker.add(item1);
        tracker.replace(item1.getId(), new Item("Item2"));
        System.out.println(tracker.findAll());
        Item rsl = tracker.findById(item1.getId());
        assertThat(rsl.getName(), is("Item2"));
    }

    @Test
    public void delete() {
        tracker.add(new Item());
        tracker.delete(1);
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void findAll() {
        Item item1 = new Item();
        tracker.add(item1);
        Item item2 = new Item();
        tracker.add(item2);
        assertEquals(tracker.findAll(), List.of(item1, item2));
    }

    @Test
    public void findByName() {
        Item item1 = new Item("test");
        tracker.add(item1);
        assertEquals(tracker.findByName("test"), List.of(item1));
    }

    @Test
    public void findById() {
        Item item1 = new Item();
        tracker.add(item1);
        assertEquals(tracker.findById(item1.getId()), item1);
    }
}