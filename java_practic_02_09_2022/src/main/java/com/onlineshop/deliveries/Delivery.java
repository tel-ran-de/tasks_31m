package com.onlineshop.deliveries;

public class Delivery {
    private final String userName;
    private final String orderName;
    private final Long amount;
    private final String email;
    private final String address;

    public Delivery(String userName, String orderName, Long amount, String email, String address) {
        this.userName = userName;
        this.orderName = orderName;
        this.amount = amount;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
                "userName='" + userName + '\'' +
                ", orderName='" + orderName + '\'' +
                ", amount=" + amount +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public String getOrderName() {
        return orderName;
    }

    public Long getAmount() {
        return amount;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
