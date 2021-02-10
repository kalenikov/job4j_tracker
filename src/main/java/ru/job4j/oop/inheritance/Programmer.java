package ru.job4j.oop.inheritance;

public class Programmer extends Engineer {
    private String[] languages;

    public Programmer(int skillLevel, String[] languages) {
        super(skillLevel);
        this.languages = languages;
    }

    public void create(Programm programm) {

    }
}
