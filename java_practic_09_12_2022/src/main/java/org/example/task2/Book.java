package org.example.task2;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Book implements Runnable {

    private final String bookName;

    private int timeReady = 2000;

    private boolean byReadyRoom = false;

    private final Queue<Reader> readers = new ConcurrentLinkedQueue<>();

    public Book(String bookName, int timeReady, boolean byReadyRoom) {
        this.bookName = bookName;
        this.timeReady = timeReady;
        this.byReadyRoom = byReadyRoom;
    }

    public String getBookName() {
        return bookName;
    }

    public int getTimeReady() {
        return timeReady;
    }

    public boolean isByReadyRoom() {
        return byReadyRoom;
    }

    public Queue<Reader> getReaders() {
        return readers;
    }

    public void addToQueueForReady(Reader reader) {
        readers.add(reader);
    }

    public void readBook(int timeReady, String readerName) {
        try {
            System.out.println(readerName + " start read " + this.bookName);
            Thread.sleep(timeReady);
            System.out.println(readerName + " finish read " + this.bookName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            while (!readers.isEmpty()) {
                Reader reader = readers.poll();
                readBook(new Random().nextInt(this.timeReady), reader.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
