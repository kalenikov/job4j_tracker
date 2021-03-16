package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
    public static void main(String[] args) {


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Bill");
        map.merge(1, "Clinton", (oldV, newV) -> oldV + " " + newV);
        System.out.println(map.get(1));
        map.merge(2, "Trump", (oldV, newV) -> oldV + " " + newV);
        System.out.println(map.get(2)); // будет выведено Trump

//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "first"); // добавляем пару ключ-значение
//        map.computeIfAbsent(2, key -> "second" + "_" + key);
// вычисляем значение для ключа, которого нет в отображении
//        System.out.println(map.get(2)); // будет выведено second_2
//        map.computeIfAbsent(1, key -> "first" + "_" + key);
// вычисляем значение для ключа, который есть в отображении
//        System.out.println(map.get(1)); // будет выведено first, т.е. значение не изменилось


//        Map<String, Integer> map = new HashMap<>();
//        int[] ar = {10,20,30};
//        map.put("a", 10);
//        map.put("b", 0);
//        map.put("ss", null);
//        map.put("sss", null);
//
//        for (int i :ar) {
//            map.put("ar",i);
//        }
//
//
//        map.compute("a", (key, value) -> value + 100);
//        map.computeIfPresent("d", (key, value) -> value + 100);
//        map.computeIfAbsent("c", key -> 400);
//
//        System.out.println(map.toString());
    }

}
