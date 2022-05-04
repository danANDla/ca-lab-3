package methods;

import equations.Equation;
import equations.EquationManager;

import java.util.HashMap;

public abstract class RiemannMethod {
    EquationManager equationManager;

    public abstract MethodResult solveEquation(int eqid, double[] borders, int iterations, HashMap<String, Double> guesses);

    public int getSteps(double[] borders, double accuracy, double maxSecondDerivativeValue){
        double result = Math.sqrt((maxSecondDerivativeValue * Math.pow((borders[1] - borders[0]), 3)) / (12 * accuracy));
        if (Math.abs(result - (int) result) < 0.000001) return (int) result;
        else return (int) result + 1;
    }

    public boolean isGap(int eqid, double v){
        Equation eq = equationManager.getEq(eqid);
        Double y = eq.getImage(v);
        if (y.isInfinite() || y.isNaN()) {
            return true;
        }
//        if (y.isNaN()) {
//            if(isGapDisposable(integral, x)) return true;
//        }
        return false;
    }
}
