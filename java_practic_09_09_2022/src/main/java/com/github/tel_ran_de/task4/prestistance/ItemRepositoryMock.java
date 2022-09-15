package com.github.tel_ran_de.task4.prestistance;

import com.github.tel_ran_de.task4.data.Item;

import java.util.Arrays;
import java.util.List;

public class ItemRepositoryMock implements ItemRepository {
    public List<Item> getItems(String query) {
        return Arrays.asList(
                new Item("test1", 1003, 9.1),
                new Item("test1", 4203, 5.1),
                new Item("test2", 5003, 8.1),
                new Item("test3", 6003, 7.1),
                new Item("test3", 1103, 7.9),
                new Item("test4", 1001, 6.5),
                new Item("test5", 1010, 8.1),
                new Item("test5", 1100, 9.1),
                new Item("test5", 1110, 7.5)

        );
    }
}
