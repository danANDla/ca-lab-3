package methods;

import equations.Equation;
import equations.EquationManager;
import exceptions.EssentialDiscontinuityException;
import exceptions.UnattainableAccuracyException;

public abstract class RiemannMethod {
    EquationManager equationManager;

    public RiemannMethod(EquationManager equationManager) {
        this.equationManager = equationManager;
    }

    public abstract MethodResult solveEquation(int eqid, double[] borders, double eps) throws EssentialDiscontinuityException, UnattainableAccuracyException;

    public boolean isGap(Equation eq, double v) throws EssentialDiscontinuityException {
        Double y = eq.getImage(v);
        if (y.isNaN()) {
            if (gapRemovable(eq, v)) {
                System.out.println("устранимый разрыв первого рода в " + v);
                return true;
            }
        }
        if (y.isInfinite()) {
            throw new EssentialDiscontinuityException("неустранимый разрыв второго рода в ", v);
        }
        return false;
    }

    public boolean gapRemovable(Equation eq, double v) throws EssentialDiscontinuityException {
        double close = 1e-7;
        double l = eq.getImage(v + close);
        double r = eq.getImage(v + close);
        if (Math.abs(l - r) < close) return true;
        else throw new EssentialDiscontinuityException("неустранимый разрыв первого рода в ", v);
    }
}
