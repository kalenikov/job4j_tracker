package ru.job4j.tracker;

public interface ReactStore extends Store {
    void findAll(Observe<Item> observe);
}