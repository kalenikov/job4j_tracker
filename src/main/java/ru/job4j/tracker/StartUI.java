package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(dtf.format(item.getCreated()));

        Tracker tracker = new Tracker();
        tracker.add(item);

        System.out.println(tracker.findById(1));

        System.out.println(item);
    }
}
