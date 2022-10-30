package task2;

public class Main {

    public static void main(String[] args) {
        doSomething(new RoadLogistics());
        doSomething(new ShipLogistics());
        //doSomething(new AirLogistics());
    }

    private static void doSomething(Logistics logistics) {
        Transport transport = logistics.createTransport();
        transport.deliver();
    }

}
