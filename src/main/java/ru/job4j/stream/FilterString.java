package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class FilterString {
    public static List<String> filter(List<String> data) {
        return data.stream()
                .filter(s -> s.endsWith("java"))
                .filter(s -> s.startsWith("java"))
                .collect(Collectors.toList());
    }
}
