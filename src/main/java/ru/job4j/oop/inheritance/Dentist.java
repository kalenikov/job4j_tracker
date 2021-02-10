package ru.job4j.oop.inheritance;

public class Dentist extends Doctor {
    private int workExperience;

    public Dentist(String hospitalId, int workExperience) {
        super(hospitalId);
        this.workExperience = workExperience;
    }

    public void pullOutTooth(Pacient pacient, int toothNumber) {
    }
}
