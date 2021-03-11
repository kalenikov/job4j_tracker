package ru.job4j.oop;

public final class LiquidationProduct {
    private Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }

    public Product getProduct() {
        return product;
    }

    public String label() {
        return product.label();
    }
}