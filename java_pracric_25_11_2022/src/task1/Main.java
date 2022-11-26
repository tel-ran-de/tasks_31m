package task1;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        // Заданы три целочисленных массива. Записать эти массивы в файл в
        // параллельных потоках. Создать класс SaveAsThread для представления
        // потока, который записывает целочисленный массив в файл.
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = {-1, -2, -3, -4, -5, -6, -7, -8, -9};
        int[] array3 = {10, 20, 30};
        new SaveAsThread(array1, "c:/soft/1.txt");
        new SaveAsThread(array2, "c:/soft/2.txt");
        new SaveAsThread(array3, "c:/soft/3.txt");
    }

}

class SaveAsThread implements Runnable {

    private final int[] array;
    private final String fileName;

    public SaveAsThread(int[] array, String fileName) {
        this.array = array;
        this.fileName = fileName;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try (PrintStream ps = new PrintStream(new FileOutputStream(fileName))) {
            for (int element : array) {
                ps.println(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
