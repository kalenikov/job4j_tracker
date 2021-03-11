package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] lefts = left.split("\\.");
        String[] rights = right.split("\\.");
        if (lefts.length == 0 || rights.length == 0) {
            return 0;
        }
        return Integer.compare(Integer.parseInt(lefts[0]), Integer.parseInt(rights[0]));
    }
}