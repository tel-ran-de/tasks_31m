package com.github.tel_ran_de.practic3009.task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest1 {
    public static void main(String[] args) {
        System.out.println("TEST1");
        Predicate<Integer> negative = i -> i < 0;
        System.out.println(negative.test(-6));
        System.out.println(negative.test(6));
        System.out.println(negative.test(0));
        System.out.println();
        System.out.println("TEST2");
        Predicate<String> containsA = t -> t.contains("A");
        Predicate<String> containsB = t -> t.contains("B");
        System.out.println(containsA.and(containsB).test("ABCD"));

        System.out.println();
        System.out.println("TEST3");
        Predicate<Integer> tester = value -> value % 2 == 1;
        List<Integer> list = Arrays.asList(10, 11, 13, 14, 15, 16, 17);
        List<Integer> newList = list.stream().filter(tester).collect(Collectors.toList());
        newList.forEach(System.out::println);

        System.out.println();
        System.out.println("TEST4");
        Predicate<String> tester1 = name -> name.startsWith("S");
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        names.stream().filter(tester1).forEach(System.out::println);
    }
}
