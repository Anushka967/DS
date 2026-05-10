import calcModule.*;

public class CalculatorImpl extends CalculatorPOA {

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {

        if (b == 0) {

            System.out.println("Cannot divide by zero");

            return 0;
        }

        return a / b;
    }
}