package task3;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Дана строка. Найти длину последнего слова
        // "qwerty, qwe!". Здесь слова - это qwerty, qwe

        String str = "Hello, qwerty Java!!!";
        String[] words = str.split("[\\s!?.,]");
//        for (String word : words) {
//            if (!word.isEmpty()) {
//                System.out.println(word);
//            }
//        }
        System.out.println(words[words.length - 1].length());

        // Аналог trim, но через регулярные выражения
        String regexp = "^\\s+|\\s+$";
        System.out.println(" qwerty ".replaceAll(regexp, ""));

    }

}
