package equations;

import java.util.ArrayList;

public class EquationManager {
    ArrayList<Equation> allEqations;

    public EquationManager() {
        allEqations = new ArrayList<>();
    }

    public ArrayList<Equation> getAllEqations() {
        return allEqations;
    }
}
