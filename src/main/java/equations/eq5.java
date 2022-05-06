package equations;

public class eq5 implements Equation{
    @Override
    public Double getImage(double v) {
        return Math.sin(v);
    }

    @Override
    public Double get1Derivative(double v) {
        return Math.cos(v);
    }

    @Override
    public Double get2Derivative(double v) {
        return -Math.sin(v);
    }

    @Override
    public String toString() {
        return "sin(x)";
    }
}
