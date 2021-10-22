package ru.job4j.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorClass {

    public static void main(String[] args) {
        List<String> list2 = Arrays.asList("a", "a", "b", "c", "d", "e", "f");

        String collect = list2.stream().collect(StringBuilder::new,
                (res, elem) -> {
                    System.out.printf("ACCUMULATE res=%s, elem=%s\n", res, elem);
                    res.append(" ").append(elem);
                },
                (res1, res2) -> {
                    System.out.printf("COMBINE res1=%s, res2=%s\n", res1, res2);
                    res1.append(res2.toString());
                }).toString();
        System.out.println("collect=" + collect);
    }

    public static List<Integer> collect(List<Integer> list) {
        Supplier<List<Integer>> supplier = LinkedList::new;
        BiConsumer<List<Integer>, Integer> biConsumer = List::add;
        BinaryOperator<List<Integer>> operator = (left, right) -> {
            left.addAll(right);
            return left;
        };
        return list.stream().collect(Collector.of(supplier, biConsumer, operator));
    }
}