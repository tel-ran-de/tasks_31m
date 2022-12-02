package task5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private Semaphore semaphore = new Semaphore(Main.CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Tunnel " + length + " meters";
    }

    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " is preparing for stage: " + description);
            semaphore.acquire();
            System.out.println(car.getName() + " starts stage: " + description);
            Thread.sleep(length / car.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(car.getName() + " ends stage: " + description);
            semaphore.release();
        }
    }
}
