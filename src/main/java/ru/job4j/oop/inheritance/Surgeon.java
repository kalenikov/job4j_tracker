package ru.job4j.oop.inheritance;

public class Surgeon extends Doctor {
    private int scalpelModel;

    public Surgeon(String hospitalId, int scalpelModel) {
        super(hospitalId);
        this.scalpelModel = scalpelModel;
    }

    public void cut(Pacient pacient) {

    }
}
