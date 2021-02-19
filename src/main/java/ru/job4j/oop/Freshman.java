package ru.job4j.oop;

public class Freshman extends Student {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student student = freshman; // расширение типа
        Object obj = freshman; // расширение типа
    }
}
