package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item was added: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id for edit: ");
                int id = scanner.nextInt();
                System.out.print("Enter new item name: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                tracker.add(newItem);
                if (tracker.replace(id, newItem)) {
                    System.out.println("The operation was successful");
                } else {
                    System.out.println("The item with this id was not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id for delete: ");
                int id = scanner.nextInt();
                if (tracker.delete(id)) {
                    System.out.println("The operation was successful");
                } else {
                    System.out.println("The item with this id was not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter id to search for: ");
                int id = scanner.nextInt();
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("The item with this id was not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name to search for: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("The items with this name was not found");
                }
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Enter a number from 0 to 6");
            }
        }
    }

    private void showMenu() {
        String menu = "Menu\n" +
                "0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n" +
                "Select:";
        System.out.println(menu);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
