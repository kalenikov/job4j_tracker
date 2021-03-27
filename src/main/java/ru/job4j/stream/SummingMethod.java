package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummingMethod {

    public static class User {
        private String name;
        private List<Bill> bills = new ArrayList<>();

        public User(String name) {
            this.name = name;
        }

        public User(String name, List<Bill> bills) {
            this.name = name;
            this.bills = bills;
        }

        public String getName() {
            return name;
        }

        public List<Bill> getBills() {
            return bills;
        }


        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Bill {
        private int balance;

        public Bill(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return "Bill{" +
                    "balance=" + balance +
                    '}';
        }
    }

    private static class Pair {
        private User user;
        private Bill bill;

        public Pair(User user, Bill bill) {
            this.user = user;
            this.bill = bill;
        }

        public User getUser() {
            return user;
        }

        public Bill getBill() {
            return bill;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "user=" + user +
                    ", bill=" + bill +
                    '}';
        }
    }

    //Вам дан список пользователей, у каждого пользователя есть счет.
    // Ваша задача найти сумму баланса для каждого пользователя.

    public static Map<String, Integer> summing(List<User> users) {
//        return users.stream()
//                .flatMap(
//                        user -> user.getBills().stream()
//                                .flatMap(bill -> Stream.of(new Pair(user, bill))))
//                .collect(Collectors.groupingBy(
//                        pair -> pair.getUser().getName(),
//                        Collectors.summingInt(pair -> pair.getBill().balance))
//                );

        return users.stream()
                .flatMap(
                        user -> user.getBills().stream()
                                .map(bill -> new Pair(user, bill)))
                .collect(Collectors.groupingBy(
                        pair -> pair.getUser().getName(),
                        Collectors.summingInt(pair -> pair.getBill().balance))
                );
    }

    public static void main(String[] args) {

        var user1 = new User("user1", List.of(new Bill(10), new Bill(15)));
        var user2 = new User("user2", List.of(new Bill(50)));


        var users = List.of(user1, user2);
        var rsl = users.stream()
                .flatMap(
                        user -> user.getBills().stream()
                                .flatMap(bill -> Stream.of(new Pair(user, bill)))).collect(
                        Collectors.groupingBy(
                                x -> x.getUser().getName(),
                                Collectors.summingInt(x -> x.getBill().balance)
                        )
                );
        System.out.println(rsl);


//        users.stream().collect(
//                Collectors.groupingBy(
//                        user -> user.getBills().stream().flatMap(bill -> Stream.of(bill))
//                )
//        );
//        User user1 = new User("user1");
//        var pair1 = new Pair(user1, new Bill(100));
//        var pair2 = new Pair(user1, new Bill(200));
//        List<Pair> pairs = List.of(pair1, pair2);
//        var rsl = pairs.stream().collect(
//                Collectors.groupingBy(
//                        x -> x.getUser().getName(),
//                        Collectors.summingInt(x -> x.getBill().balance)
//                )
//        );
//        System.out.println(rsl.toString());

    }

}