package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        Optional<Integer> max = max(data);
        max.ifPresent((x) -> System.out.println("Max: " + x));
    }

    private static Optional<Integer> max(int[] data) {
        if (data.length == 0) {
            return Optional.empty();
        }
        Arrays.sort(data);
        int max = data[data.length - 1];
        return Optional.of(max);
    }
}