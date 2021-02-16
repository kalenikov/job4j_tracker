package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("book1", 100);
        Book book2 = new Book("book2", 100);
        Book book3 = new Book("book3", 100);
        Book book4 = new Book("Clean code", 100);

        Book[] books = new Book[]{book1, book2, book3, book4};

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }

        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName());
            }
        }
    }
}
