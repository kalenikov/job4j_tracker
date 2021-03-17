package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int i1 = o1.indexOf("/");
        int i2 = o2.indexOf("/");
        if (i1 == -1) {
            return -1;
        }
        if (i2 == -1) {
            return 1;
        }
        int r = o2.substring(0, i2).compareTo(o1.substring(0, i1));
        if (r == 0) {
            return o1.substring(i1).compareTo(o2.substring(i2));
        }
        return r;
    }
}
