package Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Hello", "Java", "Spring");

        list.forEach(System.out::println);

        // 1. Создаем переменную operation типа Operationable
        Operationable operation;

        // 2. Теперь реализацией интерфейса будет не лямбда выражение, а метод methodReference
        // из класса Calculator
        operation = Calculator::sum;
        //operation = Math::addExact;

        // 3. Обратимся к методу calculate интерфейса Operationable через переменную operation
        int result = operation.calculate(10, 20);
        System.out.println(result);
    }
}

@FunctionalInterface
interface Operationable {
    int calculate(int a, int b);
}
