package com.onlineshop;

import com.onlineshop.deliveries.Delivery;
import com.onlineshop.orders.Order;
import com.onlineshop.users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryService {
    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();
        List<User> users = service.getUsers();
        List<Order> orders = service.getOrders();
        List<Delivery> deliveries = service.getDelivery(users, orders);
        for(Delivery delivery: deliveries) {
            System.out.println(delivery);
        }
    }

    public List<User> getUsers() {
        User user1 = new User("user1", "test@test.com", "rue Ford 3, Dusseldorf");
        User user2 = new User("user2", "test@test1.com", "12 rue Carmel, Luxembourg");

        return Arrays.asList(
                user1, user2
        );
    }

    public List<Order> getOrders() {
        Order order1 = new Order("user1", "Maxi toy", 224L, 2L);
        Order order2 = new Order("user1", "Lego", 124L, 1L);
        Order order3 = new Order("user2", "Renault Zoe", 220004L, 1L);
        Order order4 = new Order("user1", "Maxi toy", 224L, 1L);

        return Arrays.asList(
                order1, order2, order3, order4
        );
    }

    public List<Delivery> getDelivery(List<User> users, List<Order> orders) {
        List<Delivery> result = new ArrayList<>(orders.size());
        for (Order order : orders) {
            String userName = order.getUser();
            for (User user : users) {
                if (userName.equals(user.getName())) {
                    String orderName = order.getName();
                    String email = user.getEmail();
                    String address = user.getAddress();
                    Long amount = order.getAmount();
                    Delivery delivery = new Delivery(userName,orderName, amount, email, address);
                    result.add(delivery);
                }
            }
        }
        return result;
    }
}
