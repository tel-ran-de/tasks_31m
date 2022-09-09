package com.github.tel_ran_de.task4.prestistance;

import com.github.tel_ran_de.task4.data.Item;

import java.util.List;

public interface ItemRepository {
    /**
     * Товары с базы данных
     *
     * @return
     */
    List<Item> getItems(String query);
}
