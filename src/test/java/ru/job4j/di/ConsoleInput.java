package ru.job4j.di;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }
}
