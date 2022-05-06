package equations;

public class eq3 implements Equation {
    @Override
    public Double getImage(double v) {
        return 56.0;
    }

    @Override
    public Double get1Derivative(double v) {
        return 0.0;
    }

    @Override
    public Double get2Derivative(double v) {
        return 0.0;
    }

    @Override
    public String toString() {
        return "56";
    }
}
