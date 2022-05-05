package equations;

import java.util.ArrayList;

public class EquationManager {
    ArrayList<Equation> allEqations;

    public EquationManager() {
        allEqations = new ArrayList<>();
        allEqations.add(new eq1());
    }

    public ArrayList<Equation> getAllEqations() {
        return allEqations;
    }

    public Equation getEq(int v){return  allEqations.get(v);}
}
