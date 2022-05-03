package methods;

import equations.Equation;
import equations.EquationManager;

import java.util.HashMap;

public abstract class Riemann {
    EquationManager equationManager;

    public abstract MethodResult solveEquation(int eqid, double eps, int iterations, HashMap<String, Double> guesses);
}
