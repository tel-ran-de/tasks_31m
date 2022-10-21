package Task1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        // Получить список всех книг библиотеки, отсортированных по году
        // издания.
        List<Book> list = library.getBooks().stream()
                .sorted(Comparator.comparingInt(Book::getIssueYear))
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println();

        // Требуется создать список рассылки (объекты типа EmailAddress)
        // из адресов всех читателей библиотеки. При этом флаг согласия на
        // рассылку учитывать не будем: библиотека закрывается, так что хотим
        // оповестить всех.
        List<EmailAddress> addresses = new ArrayList<>();
        library.getReaders().forEach(reader -> addresses.add(new EmailAddress(reader.getEmail())));
        System.out.println(addresses);
        System.out.println();

        List<EmailAddress> addressesWithLambda = library.getReaders().stream()
                .map(Reader::getEmail)
                .map(EmailAddress::new)
                .collect(Collectors.toList());
        System.out.println(addressesWithLambda);
        System.out.println();

        // Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса
        // читателей, которые согласились на рассылку. Дополнительно нужно проверить,
        // что читатель взял из библиотеки больше одной книги.
        List<EmailAddress> addressesWithLambda2 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .filter(reader -> reader.getBooks().size() > 1)
                .map(Reader::getEmail)
                .map(EmailAddress::new)
                .collect(Collectors.toList());
        System.out.println(addressesWithLambda2);
        System.out.println();

        // Получить список всех книг, взятых читателями. Список не должен
        // содержать дубликатов (книг одного автора, с одинаковым названием и
        // годом издания).
        List<Book> bookList = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(bookList);

        // Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Оруэлла.
        Optional<Book> orwelBook = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .filter(book -> book.getAuthor().equals("Orwel"))
                .findFirst();
        System.out.println(orwelBook.isPresent());

        boolean match = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .anyMatch(book -> "Orwel".equals(book.getAuthor()));
        System.out.println(match);

        // Узнать наибольшее число книг, которое сейчас на руках у читателя.
        int maxBookCount = library.getReaders().stream()
                .map(reader -> reader.getBooks().size())
                .max(Integer::compareTo).orElse(-1);
        System.out.println(maxBookCount);

        // "OK" -> {}
        // "TOO_MUCH" -> {}

        // То есть надо написать метод, который вернёт два списка адресов
        // (типа EmailAddress): с пометкой OK — если книг не больше двух, или
        // TOO_MUCH — если их две и больше. Порядок групп не важен.
        Map<String, List<EmailAddress>> map = new HashMap<>();
        for (Reader reader : library.getReaders()) {
            if (reader.isSubscriber()) {
                if (reader.getBooks().size() < 2) {
                    if (!map.containsKey("OK")) {
                        map.put("OK", new ArrayList<>());
                    }
                    map.get("OK").add(new EmailAddress(reader.getEmail()));
                } else {
                    if (!map.containsKey("TOO_MUCH")) {
                        map.put("TOO_MUCH", new ArrayList<>());
                    }
                    map.get("TOO_MUCH").add(new EmailAddress(reader.getEmail()));
                }
            }
        }

        Map<String, List<EmailAddress>> map2 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(Collectors.groupingBy(r -> r.getBooks().size() < 2 ? "OK" : "TOO_MUCH",
                        Collectors.mapping(r -> new EmailAddress(r.getEmail()), Collectors.toList())));

        // Разбить читателей на две группы. Группы хранить в списках. (применение более общего
        // метода groupingBy, позволяет разбивать на большее количество групп, и использовать
        // разные ключи)
        Map<String, List<Reader>> map3 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(Collectors.groupingBy(r -> r.getBooks().size() < 2 ? "OK" : "TOO_MUCH"));

        // Разбить читателей на две группы. Группы хранить в списках (одна группа в map хранится по
        // ключу true, другая по false)
        Map<Boolean, List<Reader>> map4 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(Collectors.partitioningBy(r -> r.getBooks().size() < 2));

        // Разбить читателей на две группы. Группы хранить в списках.
        // "TOO_MUCH" -> "{Иванов Иван Иванович, Петров Петр Петрович}"
        // "OK" -> "{Иванов Иван Иванович, Петров Петр Петрович}"
        Map<String, String> map5 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(Collectors.groupingBy(r -> r.getBooks().size() < 2 ? "OK" : "TOO_MUCH",
                        Collectors.mapping(Reader::getFio, Collectors.joining(", ", "(", ")"))));


    }

}
