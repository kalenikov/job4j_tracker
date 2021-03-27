package ru.job4j.stream;

import java.util.stream.Stream;

public class StreamIterate {
    public static void showArray(Integer[] data) {
        Stream.iterate(0, i -> i <= data.length, i -> i + 1)
                .forEach(i -> {
                    if (i % 2 == 0) System.out.println(data[i]);
                });
    }
}
