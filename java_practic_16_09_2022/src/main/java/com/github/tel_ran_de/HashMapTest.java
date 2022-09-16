package com.github.tel_ran_de;

import java.util.*;

public class HashMapTest {

    public static void main(String[] args) {
        // Hi = Привет
        // World = Мир
        // Ivan = Иван
        // Car = машина
        Map<String, String> dictionary = new HashMap<>(); // словарь англо-русский
        dictionary.put("Hi".toUpperCase(Locale.ROOT), "Привет"); // приводим к одному регистру для поиска при разном написании
        dictionary.put("Hello".toUpperCase(Locale.ROOT), "Привет");
        dictionary.put("World".toUpperCase(Locale.ROOT), "Мир");
        dictionary.put("Ivan".toUpperCase(Locale.ROOT), "Иван");
        dictionary.put("Car".toUpperCase(Locale.ROOT), "Машина");

        Set<String> notTranslateWords = new HashSet<>(); // множество слов, которые мы не будет переводить
        notTranslateWords.add("a");
        notTranslateWords.add("the");
        notTranslateWords.add(" ");

        String str = "     Hello the wORld! Hi, a Car !   ".trim();
        System.out.println(str);
        String[] words = str.replace(",", "")
                .replace("!", "").split(" "); // приводим к одному виду разделителей (функций replace
        // и разбиваем на массив отдельных слов

        for (String word : words) {
            if (!notTranslateWords.contains(word)) { // исключаем слова из множества notTranslateWords
                System.out.println(dictionary.get(word.toUpperCase(Locale.ROOT))); // выводим перевод
            }
        }
    }
}
