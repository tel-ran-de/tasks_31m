package com.github.tel_ran_de.practic3009.task2;

import java.util.function.Consumer;

public class ConsumerTest2 {
    public static void main(String[] args) {
        Consumer<String> printUpperCase1 = str -> System.out.println(str.toUpperCase());
        printUpperCase1.accept("hello");

        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello");

        Consumer<String> printLowerCase = str -> System.out.println(str.toLowerCase());
        printUpperCase.andThen(printLowerCase).accept("Hello world");


    }
}
