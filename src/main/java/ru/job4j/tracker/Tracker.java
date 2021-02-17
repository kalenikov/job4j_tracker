package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) return false;
        item.setId(id);
        items[index] = item;
        return true;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item findByName(String name) {
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (name.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) return false;
        System.arraycopy(items, index + 1, items, index, size - index);
        items[size - 1] = null;
        size--;
        return true;
    }
}