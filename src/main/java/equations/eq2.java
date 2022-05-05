package equations;

public class eq2 implements Equation{
    @Override
    public Double getImage(double v) {
        return 1/v;
    }

    @Override
    public Double get1Derivative(double v) {
        return -1/(v*v);
    }

    @Override
    public Double get2Derivative(double v) {
        return 2/(v*v*v);
    }

    @Override
    public String toString() {
        return "1/x";
    }
}
