package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StringUpper {
    public static void main(String[] args) {
        var ss = List.of(
                "1. Task",
                "2. Task");
        var s = ss.stream()
                .filter(s1 -> s1.startsWith("1"))
                .findFirst()
                .stream()
                .flatMapToInt(s2 -> s2.chars())
                .mapToObj(c -> String.valueOf(Character.toUpperCase((char) c)))
                .collect(Collectors.joining());
    }
}
