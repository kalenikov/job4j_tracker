package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("ivanov@gmail.com","ivanov ivan");
        users.put("petrov@gmail.com","petrov petr");
        for (Map.Entry<String, String> user : users.entrySet()) {
            System.out.println(user.getKey() + " -- " + user.getValue());
        }
    }
}
