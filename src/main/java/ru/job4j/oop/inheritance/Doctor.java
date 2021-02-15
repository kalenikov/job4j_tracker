package ru.job4j.oop.inheritance;

public class Doctor extends Profession {
    private String hospitalId;

    public Doctor(String name, String surname, String hospitalId) {
        super(name, surname);
        this.hospitalId = hospitalId;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }

}
