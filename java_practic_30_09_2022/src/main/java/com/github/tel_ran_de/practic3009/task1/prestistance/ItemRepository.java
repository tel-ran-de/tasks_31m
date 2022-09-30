package com.github.tel_ran_de.practic3009.task1.prestistance;

import com.github.tel_ran_de.practic3009.task1.data.Item;

import java.util.List;

public interface ItemRepository {
    /**
     * Товары с базы данных
     *
     * @return
     */
    List<Item> getItems(String query);
}
