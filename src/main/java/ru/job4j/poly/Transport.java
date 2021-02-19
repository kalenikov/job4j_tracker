package ru.job4j.poly;

public interface Transport {
    void go();

    void setPassengersCount(int count);

    int fuel(int count);
}
