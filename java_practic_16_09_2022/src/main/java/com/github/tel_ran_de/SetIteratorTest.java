package com.github.tel_ran_de;

import java.util.*;

public class SetIteratorTest {
    public static void main(String[] args) {

        Set<String> notTranslateWords = new TreeSet<>(); // в алфавитном порядке сортировка
        // при LinkedHashSet - в порядке добавления, при HashSet - в любом случайном порядке
        notTranslateWords.add("a");
        notTranslateWords.add("the");
        notTranslateWords.add("a");
        notTranslateWords.add(" ");
        notTranslateWords.add("the"); // дубликаты игнорируются

        List<String> list = new ArrayList<>(notTranslateWords); // преобразование в список

        // Вывод множества (set) в алфовитном порядке
        for(String s: notTranslateWords) {
            System.out.println(s);
        }

        // Зададим Map
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Hi".toUpperCase(Locale.ROOT), "Привет");
        dictionary.put("Hello".toUpperCase(Locale.ROOT), "Привет");
        dictionary.put("World".toUpperCase(Locale.ROOT), "Мир");
        dictionary.put("Ivan".toUpperCase(Locale.ROOT), "Иван");
        dictionary.put("Car".toUpperCase(Locale.ROOT), "Машина");

        // Вывод ключей Map (преобразованием в множество (set))
        for(String word: dictionary.keySet()) {
            System.out.println(word);
        }

        // Вывод значений Map (преобразованием в список (List)
        for(String word: dictionary.values()) {
            System.out.println(word);
        }
    }
}
