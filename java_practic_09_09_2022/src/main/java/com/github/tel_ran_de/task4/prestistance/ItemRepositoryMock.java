package com.github.tel_ran_de.task4.prestistance;

import com.github.tel_ran_de.task4.data.Item;

import java.util.Arrays;
import java.util.List;

public class ItemRepositoryMock implements ItemRepository {
    public List<Item> getItems(String query) {
        return Arrays.asList(
                new Item("test1", 1003, 9.1),
                new Item("test1", 4203, 5.1),
                new Item("test1", 5003, 8.1),
                new Item("test1", 6003, 7.1)
        );
    }
}
