package methods;

import equations.Equation;
import equations.EquationManager;
import exceptions.EssentialDiscontinuityException;

import java.util.HashMap;

public abstract class RiemannMethod {
    EquationManager equationManager;

    public RiemannMethod(EquationManager equationManager) {
        this.equationManager = equationManager;
    }

    public abstract MethodResult solveEquation(int eqid, double[] borders, int steps) throws EssentialDiscontinuityException;

    public int getSteps(double[] borders, double eps, double maxSecondDerivativeValue){
        double result = Math.sqrt((maxSecondDerivativeValue * Math.pow((borders[1] - borders[0]), 3)) / (24 * eps));
        if (Math.abs(result - (int) result) < 0.000001) return (int) result;
        else return (int) result + 1;
    }

    public boolean isGap(int eqid, double v) throws EssentialDiscontinuityException {
        Equation eq = equationManager.getEq(eqid);
        Double y = eq.getImage(v);
        if (y.isInfinite()) {
            throw new EssentialDiscontinuityException();
        }
        if(y.isNaN()) return true;
        return false;
    }
}
