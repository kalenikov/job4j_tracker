package ru.job4j.oop.inheritance;

public class Builder extends Engineer {
    private String qualification;

    public Builder(int skillLevel, String qualification) {
        super(skillLevel);
        this.qualification = qualification;
    }

    public void build(Building building) {

    }
}
