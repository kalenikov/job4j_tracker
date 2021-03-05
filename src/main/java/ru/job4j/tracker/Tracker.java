package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private static Tracker instance = null;
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    private Tracker() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) return false;
        item.setId(id);
        items.set(index, item);
        return true;
    }

    private int indexOf(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String name) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (name.equals(item.getName())) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) return false;
        items.remove(index);
        return true;
    }

    public void clear(){
        items.clear();
    }
}