package ru.job4j.tracker;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Текущая дата: " + currentDate);

        LocalTime time = LocalTime.now();
        System.out.println("Текущее время: " + time);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущие дата и время: " + currentDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = dateTimeFormatter.format(currentDateTime);
        System.out.println(currentDateTimeFormat);
    }
}