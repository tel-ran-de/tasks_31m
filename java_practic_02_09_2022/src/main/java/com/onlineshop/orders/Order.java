package com.onlineshop.orders;

public class Order {
    private final String user;
    private final String name;
    private final Long price;
    private final Long amount;

    public Order(String user, String name, Long price, Long amount) {
        this.user = user;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public Long getAmount() {
        return amount;
    }
}
