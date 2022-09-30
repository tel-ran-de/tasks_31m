package com.github.tel_ran_de.practic3009.task4;

import com.onlineshop.users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TransformService {
    public List<String> getPeopleFromBerlin1(List<User> users) {
        List<String> names = new ArrayList<>();
        for (User user: users) {
            String address = user.getAddress().toLowerCase(Locale.ROOT);
            if(address.contains("berlin")) {
                names.add(user.getName());
            }
        }
        return names;
    }

    public List<String> getPeopleFromBerlin2(List<User> users) {
        List<String> names = new ArrayList<>();
        users.forEach(user -> {
            String address = user.getAddress().toLowerCase(Locale.ROOT);
            if (address.contains("berlin")) {
                names.add(user.getName());
            }
        });
        return names;
    }

    public List<String> getPeopleFromBerlin(List<User> users) {
        return users.stream()
                .filter(this::isPeopleFromBerlin)
                .map(User::getName)
                .collect(Collectors.toList());
    }

    private boolean isPeopleFromBerlin(User user) {
        return user.getAddress().toLowerCase(Locale.ROOT).contains("berlin");
    }

    public static void main(String[] args) {
        TransformService transformService = new TransformService();
        User user1 = new User("Anton", "anton@test.com", "20 allee Carmel, Berlin");
        User user2 = new User("Slava", "slava@gmail.com", "35 street One, Luxembourg");
        User user3 = new User("Sveta", "sveta@test.com", "42 street Two, berlin");

        List<String> names = transformService.getPeopleFromBerlin(Arrays.asList(user1, user2, user3));
        for(String name: names) {
            System.out.println(name);
        }
    }
}
