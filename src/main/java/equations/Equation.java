package equations;

import java.util.HashMap;

public interface Equation {
    Double getImage(HashMap<String, Double> args);
    Double get1Derivative(HashMap<String, Double> args, String diffVar);

    String toString();
}
