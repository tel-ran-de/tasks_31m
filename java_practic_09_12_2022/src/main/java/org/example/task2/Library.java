package org.example.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    private List<Thread> threads = new ArrayList<>();
    private static final int TIME_READY = 2000;

    public Library(int booksCount, int readersCount) {
        for (int i = 0; i < booksCount; i++) {
            books.add(new Book("Book" + i, new Random().nextInt(TIME_READY),  new Random().nextBoolean()));
        }
        for (int i = 0; i < readersCount; i++) {
            readers.add(new Reader("Reader" + i, books));
        }
    }

    public void startWorkLibrary() {
        for (Reader reader : readers) {
            // Запустим поток действий читателя
            Thread thread = new Thread(reader);
            threads.add(thread);
            thread.start();
        }
        // ждем окончания работы всех потоков действий читателей
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
