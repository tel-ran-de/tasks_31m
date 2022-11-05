package task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // валидация email
        String regexp = "^[a-z0-9._-]+@[a-z0-9._-]+[a-z]{3,4}$";
        System.out.println("qwerty@gm-ail.com".matches(regexp));

        // Проверка правильности баланса скобок (скобочных выражений)
        System.out.println(isCorrectBrackets("1+2*(3-4)"));
        System.out.println(isCorrectBrackets("(1+2)*(3-4)"));
        System.out.println(isCorrectBrackets("(1+2)*3-4)"));

        System.out.println();
        System.out.println("qwertyqwerty".replace('q', 'r'));
        System.out.println("qwertyqwerty".replaceAll("wert", " "));
    }

    private static boolean isCorrectBrackets(String input) {
        Pattern pattern = Pattern.compile("\\([\\d+/*-]*\\)");
        Matcher matcher = pattern.matcher(input);
        do {
            input = matcher.replaceAll("");
            matcher = pattern.matcher(input);
        } while (matcher.find());
        return input.matches("[\\d+/*-]*");
    }

}
