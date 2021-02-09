package ru.job4j.oop;

public class Cat {

     public String sound() {
        String voice = "may-may";
        return voice;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        String say = cat1.sound();
        System.out.println("cat1 says " + say);
    }
}
