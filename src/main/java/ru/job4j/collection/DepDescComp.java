package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1ar = o1.split("/");
        String[] o2ar = o2.split("/");
        int rsl = o1ar[0].compareTo(o2ar[0]);
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        return rsl;
    }
}
