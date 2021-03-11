package ru.job4j.poly;

public class Bus implements Transport {
    private int passengersCount;

    @Override
    public void go() {
        System.out.println("go");
    }

    @Override
    public void setPassengersCount(int count) {
        passengersCount = count;
    }

    @Override
    public int fuel(int count) {
        return count * 100;
    }
}
