package com.github.tel_ran_de;

import java.util.HashMap;
import java.util.Map;

// Пример обхода Map
public class MapIteratorTest {
    public static void main(String[] args) {

        // Вводим англорусских словарь
        Map<String, String> dictionary = new HashMap<>(); // при использовании HashMap порядок не опредеден
        // При использовании TreeMap - порядок сортировки ключей по алфавиту или в зависимости от compareTo
        // При использовании LinkedHashMap - порядок сортировки ключей в порядке добавления (как в списках)
        dictionary.put("Hi", "Привет");
        dictionary.put("Hello", "Привет");
        dictionary.put("World", "Мир");
        dictionary.put("Ivan", "Иван");
        dictionary.put("Car", "Машина");

        String str = "Hello Cars, Ivan52, Worlds";

        for(Map.Entry<String, String> entry: dictionary.entrySet()) { // обходим map
            String key = entry.getKey(); // получаем ключ
            String value = entry.getValue(); // получаем значние
            if(str.contains(key)) { // проверяем есть ли ключ в строке
                System.out.println(value); // выводим перевод
            }
        }
    }
}
