package ru.job4j.oop.inheritance;

public class Builder extends Engineer {
    private String qualification;

    public Builder(String name, String surname, int skillLevel, String qualification) {
        super(name, surname, skillLevel);
        this.qualification = qualification;
    }

    public void build(Building building) {

    }
}
