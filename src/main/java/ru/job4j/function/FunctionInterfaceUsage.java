package ru.job4j.function;

import java.util.*;
import java.util.function.*;


public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup1 = () -> "New String For Interface";
        System.out.println(sup1.get());

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup = () -> new HashSet<>(list);
        Set<String> strings = sup.get();
        for (String s : strings) {
            System.out.println(s);
        }

        Supplier<String> sup2 = () -> "New String For Interface";
        BiConsumer<String, String> consumer2 = (s, s1) -> System.out.println(s + s1);
        consumer2.accept(sup2.get(), " and Second String");

        List<String> list2 = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup3 = () -> new HashSet<>(list2);
        BiConsumer<Integer, String> consumer3 = (s, s1) -> System.out.println(s + s1);
        Set<String> strings2 = sup3.get();
        int i = 1;
        for (String s : strings2) {
            consumer3.accept(i++, " is " + s);
        }

        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));

        BiPredicate<String, Integer> cond = (s, i1) -> s.contains(i1.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));

        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));

        BiFunction<String, Integer, String> biFunc = (s, i2) -> s.concat(" ").concat(i2.toString());
        System.out.println("Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunc.apply("String number", 12345));

        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка поле реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка поле реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));

        BinaryOperator<StringBuilder> builder1 = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + builder1.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
