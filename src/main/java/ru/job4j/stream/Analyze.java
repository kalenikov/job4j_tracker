package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(
                        pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(
                        pupil.getName(),
                        averageScore(Stream.of(pupil))))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(
                        pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entrySet -> new Tuple(
                        entrySet.getKey(),
                        entrySet.getValue()))
                .collect(Collectors.toList());

    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(
                        pupil.getName(),
                        pupil.getSubjects().stream()
                                .mapToInt(Subject::getScore).sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple());
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entrySet -> new Tuple(
                        entrySet.getKey(),
                        entrySet.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple());
    }
}