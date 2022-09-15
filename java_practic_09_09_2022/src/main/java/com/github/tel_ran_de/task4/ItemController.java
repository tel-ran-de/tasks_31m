package com.github.tel_ran_de.task4;

import com.github.tel_ran_de.task4.data.Item;

import java.util.List;

public interface ItemController {
     enum SortedOrder {
        PRICE_LOW_HIGH, PRICE_HIGH_LOW, CUSTOM_RATING, NAME_PRICE_LOW_HIGH
    }

     List<Item> getSortedItem(String search) ;
     List<Item> getSortedItem(String search, ItemControllerImpl.SortedOrder order);
}
