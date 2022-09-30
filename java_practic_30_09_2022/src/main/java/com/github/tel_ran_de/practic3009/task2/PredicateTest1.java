package com.github.tel_ran_de.practic3009.task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest1 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("TEST4");
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        names.stream().filter(getPeopleStartWithS()).forEach(System.out::println);
        names.stream().filter(getPeopleStartWithS().negate()).forEach(System.out::println);
    }

    private static Predicate<String> getPeopleStartWithS() {
        return name -> name.startsWith("S");
    }
}
