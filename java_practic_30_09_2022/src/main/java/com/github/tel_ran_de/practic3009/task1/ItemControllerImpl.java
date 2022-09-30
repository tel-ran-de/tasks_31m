package com.github.tel_ran_de.practic3009.task1;

import com.github.tel_ran_de.practic3009.task1.data.Item;
import com.github.tel_ran_de.practic3009.task1.prestistance.ItemRepository;
import com.github.tel_ran_de.practic3009.task1.prestistance.ItemRepositoryMock;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    private final static Comparator<Item> PRICE_LOW_HIGH_COMPARATOR = Comparator.comparingLong(Item::getPriceInCents);

    private final static Comparator<Item> PRICE_HIGH_LOW_COMPARATOR = (o1, o2) -> -Long.compare(o1.getPriceInCents(), o2.getPriceInCents());

    private static Comparator<Item> getComparator(SortedOrder order) {
        switch (order) {
            case PRICE_LOW_HIGH:
                return PRICE_LOW_HIGH_COMPARATOR;
            case PRICE_HIGH_LOW:
                return PRICE_HIGH_LOW_COMPARATOR;
            case CUSTOM_RATING:
                return null;
            default:
        }
        throw new IllegalStateException("Неправильный метод сортировки");
    }

    public static void main(String[] args) {
        ItemController itemController = new ItemControllerImpl();

        System.out.println("Def sort");
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
    }
}
