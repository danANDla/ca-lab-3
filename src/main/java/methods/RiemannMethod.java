package methods;

import equations.Equation;
import equations.EquationManager;

import java.util.HashMap;

public abstract class RiemannMethod {
    EquationManager equationManager;

    public RiemannMethod(EquationManager equationManager) {
        this.equationManager = equationManager;
    }

    public abstract MethodResult solveEquation(int eqid, double[] borders, int steps);

    public int getSteps(double[] borders, double eps, double maxSecondDerivativeValue){
        double result = Math.sqrt((maxSecondDerivativeValue * Math.pow((borders[1] - borders[0]), 3)) / (24 * eps));
        if (Math.abs(result - (int) result) < 0.000001) return (int) result;
        else return (int) result + 1;
    }

    public boolean isGap(int eqid, double v){
        Equation eq = equationManager.getEq(eqid);
        Double y = eq.getImage(v);
        if (y.isInfinite()) {
            System.out.println("РАЗРЫВ ВТОРОГО РОДА");
            return true;
        }
        if(y.isNaN()) return true;
        return false;
    }
}
