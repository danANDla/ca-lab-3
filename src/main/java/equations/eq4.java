package equations;

public class eq4 implements Equation {
    @Override
    public Double getImage(double v) {
        return 5 * v + 6;
    }

    @Override
    public Double get1Derivative(double v) {
        return 5.0;
    }

    @Override
    public Double get2Derivative(double v) {
        return 0.0;
    }

    @Override
    public String toString() {
        return "5*x + 6";
    }
}
