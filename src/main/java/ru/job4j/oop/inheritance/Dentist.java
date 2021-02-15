package ru.job4j.oop.inheritance;

public class Dentist extends Doctor {
    private int workExperience;

    public Dentist(String name, String surname, String hospitalId, int workExperience) {
        super(name, surname, hospitalId);
        this.workExperience = workExperience;
    }

    public void pullOutTooth(Pacient pacient, int toothNumber) {
    }
}
