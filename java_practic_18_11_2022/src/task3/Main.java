package task3;

public class Main {

    public static final int SIZE = 10000;

    public static void main(String[] args) {
        serial();
        parallel(100);
    }

    // n - это количество потоков
    private static void parallel(int n) {
        long start = System.currentTimeMillis();
        double[][] table = new double[SIZE][SIZE];

        Thread[] threads = new Thread[n];
        int d = SIZE / n;
        for (int k = 0; k < n; k++) {
            int finalK = k;
            Runnable task = () -> {
                for (int i = 0; i < table.length; i++) {
                    int left = d * finalK;
                    int right = d * (finalK + 1) - 1;
                    if (finalK == n - 1) {
                        right = SIZE - 1;
                    }
                    for (int j = left; j < right; j++) {
                        table[i][j] = Math.pow(i, j);
                    }
                }
            };
            threads[k] = new Thread(task);
            threads[k].start();
        }

        try {
            for (int i = 0; i < n; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        double[][] table = new double[10000][10000];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = Math.pow(i, j);
            }
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

}
