package task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("<id>\b(.*)\b</id>");
        Matcher matcher = pattern.matcher("<person>\n" +
                "<id>123</id>\n" +
                "<name>John</name>\n" +
                "</person>\n" +
                "<person>\n" +
                "<id>12</id>\n" +
                "<name>Ann</name>\n" +
                "</person>");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println("123456aa".matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z_]{8,}"));

        System.out.println();

        System.out.println("word word qwerty".matches("(\\b[a-z]\\b) \1"));



    }

}
