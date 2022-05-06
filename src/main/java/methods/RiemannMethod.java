package methods;

import equations.Equation;
import equations.EquationManager;
import exceptions.EssentialDiscontinuityException;
import exceptions.UnattainableAccuracyException;

import java.util.HashMap;

public abstract class RiemannMethod {
    EquationManager equationManager;

    public RiemannMethod(EquationManager equationManager) {
        this.equationManager = equationManager;
    }

    public abstract MethodResult solveEquation(int eqid, double[] borders, double eps) throws EssentialDiscontinuityException, UnattainableAccuracyException;

    public int getSteps(double[] borders, double eps, double maxSecondDerivativeValue){
        double result = Math.sqrt((maxSecondDerivativeValue * Math.pow((borders[1] - borders[0]), 3)) / (24 * eps));
        if (Math.abs(result - (int) result) < 0.000001) return (int) result;
        else return (int) result + 1;
    }

    public boolean isGap(int eqid, double v) throws EssentialDiscontinuityException {
        Equation eq = equationManager.getEq(eqid);
        Double y = eq.getImage(v);
        if(y.isNaN()){
            if(gapRemovable(eqid, v)){
                System.out.println("устранимый разрыв первого рода в " + v);
                return true;
            }
        }
        if (y.isInfinite()) {
            throw new EssentialDiscontinuityException("неустранимый разрыв второго рода в ", v);
        }
        return false;
    }

    public boolean gapRemovable(int eqid, double v) throws EssentialDiscontinuityException{
        Equation eq = equationManager.getEq(eqid);
        double close = 1e-7;
        double l = eq.getImage(v + close);
        double r = eq.getImage(v + close);
        if(Math.abs(l-r) < close) return true;
        else throw new EssentialDiscontinuityException("неустранимый разрыв первого рода в ", v);
    }
}
