package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        var leftMap = new HashMap<Character, Integer>();
        for (Character c : left.toCharArray()) {
            leftMap.putIfAbsent(c, 0);
            leftMap.compute(c, (k, v) -> ++v);
        }
        for (Character c : right.toCharArray()) {
            if (!leftMap.containsKey(c)) {
                return false;
            }
            if (leftMap.get(c) == 1) {
                leftMap.remove(c);
            } else {
                leftMap.compute(c, (k, v) -> --v);
            }
        }
        return leftMap.isEmpty();
    }
}