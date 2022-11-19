package task2;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (200 * Math.random() - 100);
        }
        new Thread(() -> System.out.println("min = " + min(array))).start();
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("max = " + max);
    }

    private static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

}
