package com.github.tel_ran_de.task4;

import com.github.tel_ran_de.task4.data.Item;
import com.github.tel_ran_de.task4.prestistance.ItemRepository;
import com.github.tel_ran_de.task4.prestistance.ItemRepositoryMock;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ItemControllerImpl implements ItemController {
    private final ItemRepository itemRepository = new ItemRepositoryMock();

    public List<Item> getSortedItem(String search) {
        List<Item> itemList = itemRepository.getItems(search);
        Collections.sort(itemList);
        return itemList;
    }

    /**
     *
     * @param search
     * @param order - возможные значение PRICE_LOW_HIGH, PRICE_HIGH_LOW, CUSTOM_RATING
     * @return
     */
    public List<Item> getSortedItem(String search, SortedOrder order) {
        Comparator<Item> comparator = getComparator(order);
        List<Item> itemList = itemRepository.getItems(search);
        itemList.sort(comparator);
        return itemList;
    }

    private final static Comparator<Item> PRICE_LOW_HIGH_COMPARATOR = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Long.compare(o1.getPriceInCents(), o2.getPriceInCents());
        }
    };

    private final static Comparator<Item> PRICE_HIGH_LOW_COMPARATOR = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return -Long.compare(o1.getPriceInCents(), o2.getPriceInCents());
        }
    };

    private final static Comparator<Item> CUSTOM_RATING_COMPARATOR = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o2.getRating(), o1.getRating());
        }
    };

    private final static Comparator<Item> NAME_PRICE_LOW_HIGH_COMPARATOR = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            if (!Objects.equals(o1.getName(), o2.getName())) {
                if (Objects.equals(o1.getName(), o2.getName())) {return 0;}
                if (o1.getName() == null) {return -1;}
                if (o2.getName() == null) {return 1;}
                return o1.getName().compareTo(o2.getName());
            }
            return Long.compare (o1.getPriceInCents(), o2.getPriceInCents());
        }
    };

    private static Comparator<Item> getComparator(SortedOrder order) {
        switch (order) {
            case PRICE_LOW_HIGH:
                return PRICE_LOW_HIGH_COMPARATOR;
            case PRICE_HIGH_LOW:
                return PRICE_HIGH_LOW_COMPARATOR;
            case CUSTOM_RATING:
                return CUSTOM_RATING_COMPARATOR;
            case NAME_PRICE_LOW_HIGH:
                return NAME_PRICE_LOW_HIGH_COMPARATOR;
            default:
        }
        throw new IllegalStateException("Неправильный метод сортировки");
    }

    public static void main(String[] args) {
        ItemController itemController = new ItemControllerImpl();

        System.out.println("PRICE_LOW_HIGH");
        List<Item> itemList = itemController.getSortedItem("toy");

        for(Item item: itemList) {
            System.out.println(item);
        }

        System.out.println();
        System.out.println();

        System.out.println("PRICE_HIGH_LOW");

        List<Item> itemList1 = itemController.getSortedItem("toy",
                SortedOrder.PRICE_HIGH_LOW);

        for(Item item: itemList1) {
            System.out.println(item);
        }

        System.out.println("\n\nCUSTOM_RATING");
        List<Item> itemListCustom = itemController.getSortedItem("toy", SortedOrder.CUSTOM_RATING);

        for (Item item : itemListCustom) {
            System.out.println(item);
        }

        System.out.println("\n\nNAME_PRICE_LOW_HIGH");
        List<Item> itemListNamePrice = itemController.getSortedItem("toy", SortedOrder.NAME_PRICE_LOW_HIGH);

        for (Item item : itemListNamePrice) {
            System.out.println(item);
        }
    }
}
