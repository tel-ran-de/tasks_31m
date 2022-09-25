package com.github.tel_ran_de;

import java.util.*;

public class HashMapExtTest {

    public static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
    public static class Order {
        String orderName;
        User user;
        String town;
        String street;
        String house;

        public Order(String orderName, User user, String town, String street, String house) {
            this.orderName = orderName;
            this.user = user;
            this.town = town;
            this.street = street;
            this.house = house;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>(
                Arrays.asList(
                    new Order("toy", new User("petya", "test@test.com"), "Moscow", "moskovsaki", "22"),
                    new Order("car", new User("slava", "test1@gmail.com"), "Samara", "moskovsaki", "22"),
                    new Order("car", new User("petya", "test@test.com"), "Samara", "moskovsaki", "22"),
                    new Order("car", new User("petya", "test@test.com"), "Samara", "moskovsaki", "22"),
                    new Order("table", new User("petya", "test@test.com"), "Novgorod", "moskovsaki", "22")
                )
        );
        Set<String> emailSet = new HashSet<>();
        for(Order order: orders) {
            String email = order.user.email;
            emailSet.add(email);
        }

        for(String email: emailSet) {
            System.out.println(email);
        }



        int i = (int) Math.floor(Math.random() * 11.0);
        System.out.println(i);


        String[] wordArray = {"Этот","отель","был","ужасным"};

        Set<String> goodWords = new HashSet<>(Arrays.asList(
                "отлично", "класс"
        ));

        Set<String> badWords = new HashSet<>(Arrays.asList(
                "ужасно", "ужасным"
        ));

        int goodRate = 0;
        for(String word: wordArray) {
            if(goodWords.contains(word)) {
                goodRate++;
            } else if(badWords.contains(word)) {
                goodRate--;
            }
        }

        System.out.println(goodRate);


        Set<String> urls = new HashSet<>();
        urls.add("gooole.com");
        urls.add("amazon.com");
        urls.add("gooole.com");

        for (String str: urls) {
            System.out.println(str);
        }

        System.out.println(urls.contains("amazon.com"));
        System.out.println(urls.contains("test.com"));





        // Hi = Привет
        // World = Мир
        // Ivan = Иван
        // Car = машина
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Hi".toUpperCase(Locale.ROOT), "Привет");
        dictionary.put("Hello".toUpperCase(Locale.ROOT), "Привет");
        dictionary.put("World".toUpperCase(Locale.ROOT), "Мир");
        dictionary.put("Ivan".toUpperCase(Locale.ROOT), "Иван");
        dictionary.put("Car".toUpperCase(Locale.ROOT), "Машина");

        Set<String> notTranslateWords = new HashSet<>();
        notTranslateWords.add("a");
        notTranslateWords.add("the");
        notTranslateWords.add(" ");

        String str = "     Hello the wORld! Hi, a Car !   ".trim();
        System.out.println(str);
        String[] words = str.replace(",", "")
                .replace("!", "").split(" ");

        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (!notTranslateWords.contains(word)) {
                System.out.println(dictionary.get(word.toUpperCase(Locale.ROOT)));
            }
        }
    }
}
