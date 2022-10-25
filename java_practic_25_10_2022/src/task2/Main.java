package task2;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Optional<Integer> min = numbers.stream()
                .min(Integer::compare);
        Random rnd = new Random();
        System.out.println(min.orElseGet(() -> rnd.nextInt(100)));

        System.out.println(min.orElseThrow(IllegalStateException::new));


    }

}
