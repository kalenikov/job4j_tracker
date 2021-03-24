package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToList {
    public static List<Integer> convert(Integer[][] data) {
        return Stream.of(data)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}