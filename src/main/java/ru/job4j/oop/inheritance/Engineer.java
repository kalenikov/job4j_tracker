package ru.job4j.oop.inheritance;

public class Engineer extends Profession {
    private int skillLevel;

    public Engineer(String name, String surname, int skillLevel) {
        super(name, surname);
        this.skillLevel = skillLevel;
    }
}
