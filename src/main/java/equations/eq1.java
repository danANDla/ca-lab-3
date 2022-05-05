package equations;

public class eq1 implements Equation {
    @Override
    public Double getImage(double v) {
        return Math.sin(v) / v;
    }

    @Override
    public Double get1Derivative(double v) {
        return (Math.cos(v) * v - Math.sin(v)) / (v * v);
    }

    @Override
    public Double get2Derivative(double x) {
        return ((x * x - 2) * Math.sin(x) + 2 * x * Math.cos(x)) / (x * x * x);
    }

    @Override
    public String toString() {
        return "sin(x)/x";
    }
}
