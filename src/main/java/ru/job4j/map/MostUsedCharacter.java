package ru.job4j.map;

import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        String[] ss = str.toLowerCase().replace(" ", "").split("");
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String s : ss) {
            map.putIfAbsent(s, 1);
            map.compute(s, (k, v) -> ++v);
        }
        int max = Collections.max(map.values());
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == max) {
                return e.getKey().charAt(0);
            }
        }
        return ' ';
    }
}