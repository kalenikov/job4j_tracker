package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void itemSortAsc() {
        Item item5 = new Item(5);
        Item item100 = new Item(100);
        Item item1 = new Item(1);
        List<Item> items = Arrays.asList(item5, item100, item1);
        List<Item> itemsSorted = List.of(item1, item5, item100);
        Collections.sort(items);
        assertThat(items, is(itemsSorted));
    }

    @Test
    public void itemSortDesc() {
        Item item5 = new Item(5);
        Item item100 = new Item(100);
        Item item1 = new Item(1);
        List<Item> items = Arrays.asList(item5, item100, item1);
        List<Item> itemsSorted = Arrays.asList(item100, item5, item1);
        Collections.sort(items, Comparator.reverseOrder());
        assertThat(items, is(itemsSorted));
    }
}