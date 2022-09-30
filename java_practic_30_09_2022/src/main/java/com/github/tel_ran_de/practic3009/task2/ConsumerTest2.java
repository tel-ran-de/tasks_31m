package com.github.tel_ran_de.practic3009.task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest2 {
    public static void main(String[] args) {
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello");

        Consumer<String> printLowerCase = str -> System.out.println(str.toLowerCase());
        printUpperCase.andThen(printLowerCase).accept("Hello world");

        List<String> list = Arrays.asList("test1", "test2");
        list.forEach(
                System.out::println
        );
    }
}
