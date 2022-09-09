package com.github.tel_ran_de.task3;

import java.util.Objects;

public class Task3 {
    public static void main(String[] args) {
        Order order1 = new Order();
        order1.name = "Лего";
        order1.price = 100.0;

        Order order2 = new Order();
        order2.name = "Лего";
        order2.price = 100.0;

        System.out.println(order1.hashCode() == order2.hashCode() && order1.equals(order2));
    }

    public static class Order {
        private String name;
        private Double price;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Order order = (Order) o;
            return Objects.equals(name, order.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
