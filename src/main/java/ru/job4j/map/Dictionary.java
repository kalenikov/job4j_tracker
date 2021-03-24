package ru.job4j.map;

import java.util.*;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String f = String.valueOf(s.charAt(0));
            if (null != map.putIfAbsent(f, new ArrayList<>(Arrays.asList(s)))) {
                map.compute(f, (k, v) -> {
                    v.add(s);
                    return v;
                });
            }
        }
        return map;
    }
}