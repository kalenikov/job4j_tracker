package ru.job4j.oop;

public class Bug {
    private String name;

    public static void main(String[] args) {
        String issue = "Fix me ASAP.";
        Bug item = new Bug(issue);
    }

    public Bug(String text) {
        this.name = text;
    }
}
