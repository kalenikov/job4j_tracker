package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUsage {
    public static void main(String[] args) {
//        List<Integer> rsl = new ArrayList<>(Arrays.asList(10, -20, 30, -40, 50));
//        Stream<Integer> stream = rsl.stream();
//        rsl = stream.filter(x -> x > 0).collect(Collectors.toList());
//        System.out.println(rsl);

//        List<Integer> tasks =
        List<Integer> rsl = List.of(10, -20, 30, -40, 50).stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        System.out.println(rsl);
    }
}
