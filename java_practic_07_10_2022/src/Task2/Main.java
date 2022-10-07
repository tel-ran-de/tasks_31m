package Task2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<IntBinaryOperator> operations = new ArrayList<>();
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+') {
                operations.add((a, b) -> a + b);
            } else if (c == '-') {
                operations.add((a, b) -> a - b);
            } else {
                // с - цифра
                numbers.add(Integer.parseInt("" + c));
            }
        }
        int a = numbers.get(0);
        int b = numbers.get(1);
        IntBinaryOperator operation = operations.get(0);
        int result = operation.applyAsInt(a, b);
        System.out.println(result);
    }
}