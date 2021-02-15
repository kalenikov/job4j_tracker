package ru.job4j.oop.inheritance;

public class Surgeon extends Doctor {
    private int scalpelModel;

    public Surgeon(String name, String surname, String hospitalId, int scalpelModel) {
        super(name, surname, hospitalId);
        this.scalpelModel = scalpelModel;
    }

    public void cut(Pacient pacient) {

    }
}
