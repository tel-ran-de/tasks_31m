package task5;

public class Road extends Stage {

    public Road(int length) {
        this.length = length;
        this.description = "Road " + length + " meters";
    }

    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " starts stage: " + description);
            Thread.sleep(length / car.getSpeed() * 1000);
            System.out.println(car.getName() + " ends stage: " + description);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
