package equations;

public interface Equation {
    Double getImage(double v);
    Double get1Derivative(double v);
    Double get2Derivative(double v);
    String toString();
}
