package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String s : strings) {
            if (null == map.computeIfPresent(s, (k, v) -> true)) {
                map.put(s, false);
            }
        }
        return map;
    }
}