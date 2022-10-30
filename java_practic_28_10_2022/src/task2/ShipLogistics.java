package task2;

public class ShipLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Ship();
    }

}
