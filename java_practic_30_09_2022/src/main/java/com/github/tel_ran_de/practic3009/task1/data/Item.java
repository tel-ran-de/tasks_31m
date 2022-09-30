package com.github.tel_ran_de.practic3009.task1.data;


public class Item implements Comparable<Item>{
    private String name;
    private long priceInCents;
    private Double rating;

    public Item(String name, long priceInCents, Double rating) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public long getPriceInCents() {
        return priceInCents;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public int compareTo(Item o) {
        return Long.compare(priceInCents, o.priceInCents);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", priceInCents=" + priceInCents +
                ", rating=" + rating +
                '}';
    }
}
