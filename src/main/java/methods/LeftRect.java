package methods;

import equations.Equation;
import equations.EquationManager;

import java.util.Arrays;
import java.util.HashMap;

public class LeftRect extends RiemannMethod {


    public LeftRect(EquationManager equationManager) {
        super(equationManager);
    }

    private double getSquare(int eqid, double[] borders) {
        System.out.println(Arrays.toString(borders));
        Equation eq = equationManager.getEq(eqid);
        if (eq.getImage(borders[0]) * eq.getImage(borders[1]) >= 0) {
            return Math.abs(borders[1] - borders[0]) * eq.getImage(borders[0]);
        }
        double t = borders[1];
        if(eq.getImage(t) >= 0) while (eq.getImage(t) >= 0) t -= 0.000001;
        else if(eq.getImage(t) < 0) while (eq.getImage(t) < 0) t -= 0.000001;
        return getSquare(eqid, new double[]{borders[0], t}) + getSquare(eqid, new double[]{t, borders[1]});
    }

    @Override
    public MethodResult solveEquation(int eqid, double[] borders, double eps) {
        Equation eq = equationManager.getEq(eqid);
        double point = borders[0];
        double ans = 0;

        double maxDer = eq.getSecondDerivativeMaxValue(borders);
        int steps = getSteps(borders, eps, maxDer);
        double step = Math.abs(borders[0] - borders[1]) / steps;

        while (steps-- > 0) {
            if (isGap(eqid, point)) {
                point += 0.000001;
                continue;
            }
            if (Math.abs(point) < 0.00000001) point = 0.0;

            ans += getSquare(eqid, new double[]{point, point + step});
            point += step;
        }
        return new MethodResult(ans, SolutionStatus.OK);
    }
}
