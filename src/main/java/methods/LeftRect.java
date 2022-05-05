package methods;

import equations.Equation;
import equations.EquationManager;
import exceptions.EssentialDiscontinuityException;

import java.util.Arrays;
import java.util.HashMap;

public class LeftRect extends RiemannMethod {


    public LeftRect(EquationManager equationManager) {
        super(equationManager);
    }

    private double getSquare(int eqid, double[] borders) {
        Equation eq = equationManager.getEq(eqid);
        if (eq.getImage(borders[0]) * eq.getImage(borders[1]) >= 0) {
            return Math.abs(borders[1] - borders[0]) * eq.getImage(borders[0]);
        }
        double t = borders[1];
        if (eq.getImage(t) >= 0) while (eq.getImage(t) > 0) t -= 0.000001;
        else if (eq.getImage(t) < 0) while (eq.getImage(t) < 0) t -= 0.000001;

        return getSquare(eqid, new double[]{borders[0], t}) + getSquare(eqid, new double[]{t + 0.0000011, borders[1]});
    }

    @Override
    public MethodResult solveEquation(int eqid, double[] borders, int steps) throws EssentialDiscontinuityException {
        Equation eq = equationManager.getEq(eqid);
        double point = borders[0];
        double ans = 0;

        double maxDer = eq.get2DerivativeMaxValue(borders);
        double step = Math.abs(borders[0] - borders[1]) / steps;

        while (steps-- > 0) {
            if (Math.abs(point) < 0.00000001) point = 0.0;
            if (isGap(eqid, point)) {
                point += 0.000001;
                continue;
            }
            ans += getSquare(eqid, new double[]{point, point + step});
            point += step;
        }
        return new MethodResult(ans, SolutionStatus.OK);
    }
}
