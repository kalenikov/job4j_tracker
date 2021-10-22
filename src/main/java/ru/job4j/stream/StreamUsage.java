package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {

        List<Integer> rsl = List.of(10, -20, 30, -40, 50).stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        System.out.println(rsl);
    }
}
