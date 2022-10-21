package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        init();
    }

    private void init() {
        books = new ArrayList<>();
        books.add(new Book("Orwel", "1984", 2021));
        books.add(new Book("Arthur Conan Doyle", "Sherlock Holmes Investigates", 2020));
        books.add(new Book("Khaled Hosseini", "The Kite Runner", 2003));
        books.add(new Book("Jules Verne", "Voyage au centre de la Terre", 1874));
        Book book5 = new Book("Qwerty", "asdfg", 2020);
        books.add(book5);
        //и так далее для других книг

        readers = new ArrayList<>();
        readers.add(new Reader("Ivanov Ivan Ivanovich", "ivanov.email@test.ru", true));
        Reader reader2 = new Reader("Petrov Petr", "petrov@gmail.com", true);
        readers.add(reader2);
        //и так далее для других читателей

        readers.get(0).getBooks().add(books.get(0));
        readers.get(0).getBooks().add(books.get(3));
        readers.get(0).getBooks().add(books.get(1));
        reader2.getBooks().add(book5);
        reader2.getBooks().add(books.get(3));
        //и так далее для других читателей и взятых книг
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(String bookName) {
        return books.stream()
                .filter(b -> b.getName().equals(bookName))
                .findFirst()
                .orElse(null);
    }

    public List<Reader> getReaders() {
        return readers;
    }

}
