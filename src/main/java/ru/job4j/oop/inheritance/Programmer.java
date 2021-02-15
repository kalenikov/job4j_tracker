package ru.job4j.oop.inheritance;

public class Programmer extends Engineer {
    private String[] languages;

    public Programmer(String name, String surname, int skillLevel, String[] languages) {
        super(name, surname, skillLevel);
        this.languages = languages;
    }

    public void create(Programm programm) {

    }
}
