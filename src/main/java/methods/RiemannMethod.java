package methods;

import equations.Equation;
import equations.EquationManager;
import exceptions.EssentialDiscontinuityException;
import exceptions.UnattainableAccuracyException;

public abstract class RiemannMethod {
    private EquationManager equationManager;
    private boolean debug;

    public EquationManager getEquationManager() {
        return equationManager;
    }

    public boolean isDebug() {
        return debug;
    }

    public RiemannMethod(EquationManager equationManager, boolean debug) {
        this.equationManager = equationManager;
        this.debug = debug;
    }

    public abstract MethodResult solveEquation(int eqid, double[] borders, double eps) throws EssentialDiscontinuityException, UnattainableAccuracyException;
}
