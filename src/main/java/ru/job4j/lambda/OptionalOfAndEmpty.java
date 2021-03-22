package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        for (String string : strings) {
            if (value.equals(string)) {
                return Optional.of(string);
            }
        }
        return Optional.empty();

    }
}
