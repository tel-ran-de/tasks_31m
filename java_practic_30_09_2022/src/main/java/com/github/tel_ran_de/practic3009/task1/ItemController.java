package com.github.tel_ran_de.practic3009.task1;

import com.github.tel_ran_de.practic3009.task1.data.Item;

import java.util.List;

public interface ItemController {
     enum SortedOrder {
        PRICE_LOW_HIGH, PRICE_HIGH_LOW, CUSTOM_RATING
    }

     List<Item> getSortedItem(String search) ;
     List<Item> getSortedItem(String search, ItemControllerImpl.SortedOrder order);
}
