
public class Calculator {

    ICalculator icalc;

    public Calculator(ICalculator icalc) {
        this.icalc = icalc;
    }

    public double add(double a, double b) {
        return icalc.add(a, b);
    }

    public double sub(double a, double b) {
        return icalc.sub(a, b);
    }

    public double mul(double a, double b) {
        return icalc.mul(a, b);
    }

    public double div(double a, double b) {
        return icalc.div(a, b);
    }

    public double double15() {
        return 15.0;
    }

}
