package ru.job4j.map;

import java.util.*;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String ss) {
        Map<Character, List<Integer>> map = new HashMap<>();
        ss = ss.replace(" ", "");
        for (int i = 0; i < ss.length(); i++) {
            Character c = ss.charAt(i);
            if (!map.containsKey(c)) {
                ArrayList<Integer> ar = new ArrayList<>();
                int index = ss.indexOf(c, i);
                while (index >= 0) {
                    ar.add(index);
                    index = ss.indexOf(c, index + 1);
                }
                map.put(c, ar);
            }
        }
        return map;
    }
}