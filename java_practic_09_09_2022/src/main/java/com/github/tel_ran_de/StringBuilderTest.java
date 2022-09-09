package com.github.tel_ran_de;

public class StringBuilderTest {
    public static void main(String[] args) {
        String s = "12"; // 12

        StringBuilder builder = new StringBuilder("f");
        builder.append("a").append("t");
        String s1 = builder.toString();

    }
}
