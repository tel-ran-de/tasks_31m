package Task3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        // Получить список всех книг библиотеки, отсортированных по году
        // издания.
        List<Book> list = library.getBooks().stream()
                .sorted(Comparator.comparingInt(Book::getIssueYear))
                .collect(Collectors.toList());


    }

}
