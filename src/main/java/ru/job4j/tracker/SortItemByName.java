package ru.job4j.tracker;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class SortItemByName implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
