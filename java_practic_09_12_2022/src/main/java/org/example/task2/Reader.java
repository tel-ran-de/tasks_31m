package org.example.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reader implements Runnable {

    private String name;

    // список книг в библиотеке
    private List<Book> booksInLibrary;

    private List<Book> booksByReady = new ArrayList<>();
    private List<Thread> threadsBooksByReady = new ArrayList<>();

    private static final int ACTION_NO_VISIT = 0;       // действие "не приходить в библиотеку"
    private static final int ACTION_IN_LIBRARY = 1;     // действие "прийти в библиотеку"

    private static final int ACTION_IN_LIBRARY_NO_ACTION = 0;   // действие ничего не делать в библиотеке
    private static final int ACTION_IN_LIBRARY_GET_BOOK = 1;    // Выбрать книгу для чтения
    private static final int ACTION_IN_LIBRARY_OUT_LIBRARY = 2; // действие уйти из библиотеки

    public Reader(String name, List<Book> booksInLibrary) {
        this.name = name;
        this.booksInLibrary = booksInLibrary;
    }

    public String getName() {
        return name;
    }

    // метод выбирает случайным образом действие читателя
    private int getActionReader(int actionValueCount) {
        return new Random().nextInt(actionValueCount);
    }

    private Book getBookForReady() {
        Book book = null;
        if (booksInLibrary.size() > 0) {
            int indexBook = new Random().nextInt(booksInLibrary.size());
            book = booksInLibrary.get(indexBook);
        }
        // Если книгу выбрали и ее еще нет в списке у читателя
        if (book != null && !booksByReady.contains(book)) {
            booksByReady.add(book);
        } else {
            book = null;
        }
        if (book != null) {
            System.out.println(this.name + " chose the book " + book.getBookName());
        }
        return book;
    }

    // Метод поведения читателя в библиотеке
    @Override
    public void run() {
        try {
            int action = getActionReader(2);
            if (action == ACTION_NO_VISIT) {
                System.out.println(this.name + " won't come to library");
                return;
            }
            if (action == ACTION_IN_LIBRARY) {
                Thread.sleep(new Random().nextInt(100));
                System.out.println(this.name + " come to library");
            }
            action = -1;
            while (action != ACTION_IN_LIBRARY_OUT_LIBRARY) {
                action = getActionReader(3);
                if (action == ACTION_IN_LIBRARY_NO_ACTION) {
                    continue;
                }
                if (action == ACTION_IN_LIBRARY_GET_BOOK) {
                    Book book = getBookForReady();
                    if (book != null) {
                        // Добавляем читателя в очередь на чтение книги
                        book.addToQueueForReady(this);
                        // Если очередь на чтение книги пустая, то запустим поток
                        // для обработки очереди на чтение
                        if (book.getReaders().isEmpty()) {
                            // Запустим поток чтения книги
                            Thread thread = new Thread(book);
                            threadsBooksByReady.add(thread);
                            thread.start();
                        }
                    }
                    Thread.sleep(new Random().nextInt(100));
                    continue;
                }
                if (action == ACTION_IN_LIBRARY_OUT_LIBRARY) {
                    int countThreads = threadsBooksByReady.size();
                    while (countThreads > 0) {
                        for (Thread thread : threadsBooksByReady) {
                            if (thread.getState() == Thread.State.TERMINATED) {
                                countThreads--;
                            }
                            Thread.sleep(200);
                        }
                    }
                    System.out.println(this.name + " left library");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
