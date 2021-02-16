package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setCreated(new Date());
        student.setName("test name");
        student.setGroupId(1);

        System.out.println("new student " + student.getName() +
                " created at " + student.getCreated() +
                " in group " + student.getGroupId());
    }
}
