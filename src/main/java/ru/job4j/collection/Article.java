package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        return stringToSet(origin).containsAll(stringToSet(line));
    }

    private static Set<String> stringToSet(String string) {
        String[] rsl = string.toLowerCase().replaceAll("\\p{Punct}", "").split("\\s+");
        return new HashSet<>(Arrays.asList(rsl));
    }
}
