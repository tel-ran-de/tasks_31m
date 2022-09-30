package com.github.tel_ran_de.practic3009.task2;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());
    }
}
