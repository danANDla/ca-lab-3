package methods;

import equations.EquationManager;
import exceptions.EssentialDiscontinuityException;
import exceptions.UnattainableAccuracyException;

public abstract class RectMethod {
    private EquationManager equationManager;
    private boolean debug;

    public EquationManager getEquationManager() {
        return equationManager;
    }

    public boolean isDebug() {
        return debug;
    }

    public RectMethod(EquationManager equationManager, boolean debug) {
        this.equationManager = equationManager;
        this.debug = debug;
    }

    public abstract int GetSteps(int eqid, double[] borders, double eps) throws EssentialDiscontinuityException, UnattainableAccuracyException;
    public abstract MethodResult solveEquation(int eqid, double[] borders, int steps) throws EssentialDiscontinuityException;
}
