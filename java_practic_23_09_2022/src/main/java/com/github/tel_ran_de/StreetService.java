package com.github.tel_ran_de;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StreetService {
    private static class Address {
        String town;
        String street;
        String number;

        public Address(String town, String street, String number) {
            this.town = town;
            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "{" +
                    "town='" + town + '\'' +
                    ", street='" + street + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }

    private static class Key {
        String town;
        String street;

        public Key(String town, String street) {
            this.town = town;
            this.street = street;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(town, key.town) && Objects.equals(street, key.street);
        }

        @Override
        public int hashCode() {
            return Objects.hash(town, street);
        }
    }

    private Map<Key, Address> map = new HashMap<>();

    public static void main(String[] args) {
        Address address = new Address("Samara", "NewStreet", "21");
        Map<String, Map<String, Address>> map = new HashMap<>();
        map.putIfAbsent("Samara", new HashMap<>());
        map.get("Samara").put("NewStreet", address);
        System.out.println(map.get("Samara").get("NewStreet"));

        Map<Key, Address> map1 = new HashMap<>();
        map1.put(new Key("Samara", "NewStreet"), address);
        System.out.println(map1.get(new Key("Samara", "NewStreet")));

    }
}
