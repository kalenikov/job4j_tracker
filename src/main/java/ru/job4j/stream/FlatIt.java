package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        var rsl = new ArrayList<Integer>();
        it.forEachRemaining(flatIt -> flatIt.forEachRemaining(rsl::add));
        return rsl;
    }
}
