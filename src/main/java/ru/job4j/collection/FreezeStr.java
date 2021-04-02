package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        //разбиваем строку в массив символов,
        //собираем в мапу(Символ, Количество в строке) и сравниваем
        return stringToMap(left).equals(stringToMap(right));
    }

    public static Map<Character, Integer> stringToMap(String string) {
        var rsl = new HashMap<Character, Integer>();
        for (Character c : string.toCharArray()) {
            rsl.putIfAbsent(c, 0);
            rsl.compute(c, (k, v) -> ++v);
        }
        return rsl;
    }
}