package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public Map<String, Student> collectToMap(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .distinct()
                .collect(Collectors.toMap(Student::getSurname, e -> e));
    }

}
