package ru.job4j.lambda;

import java.util.function.Consumer;

public class ConsumerAndThen {
    public static Consumer<String> consumer(String input) {
        Consumer<String> print = System.out::print;
        Consumer<String> ln = (x) -> System.out.println();
        return print.andThen(ln);
    }
}