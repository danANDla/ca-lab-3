package methods;

import equations.Equation;
import equations.EquationManager;
import exceptions.EssentialDiscontinuityException;
import exceptions.UnattainableAccuracyException;

public class LeftRect extends RiemannMethod {

    public LeftRect(EquationManager equationManager) {
        super(equationManager);
    }

    @Override
    public MethodResult solveEquation(int eqid, double[] borders, double eps) throws EssentialDiscontinuityException, UnattainableAccuracyException {
        Equation eq = equationManager.getEq(eqid);
        int n1 = 20;
        int m = 2;
        double h = Math.abs(borders[0] - borders[1]) / n1;

        double int1 = integrate(eq, borders, h, n1);
        h = Math.abs(borders[0] - borders[1]) / (n1 * m);
        double int2 = integrate(eq, borders, h, n1 * m);
        System.out.println("n=" + n1 + ", int = " + int1);
        System.out.println("n=" + n1 * m + ", int = " + int2);

        int iter = 0;
        while (!rungeRule(int1, int2, eps) && iter < 1000000) {
            int1 = int2;
            n1 *= m;
            h = Math.abs(borders[0] - borders[1]) / (n1 * m);
            int2 = integrate(eq, borders, h, n1 * m);
            System.out.println("n=" + n1 * m + ", int = " + int2);
            iter++;
        }
        if (iter == 1000000) throw new UnattainableAccuracyException();
        return new MethodResult(int2, SolutionStatus.OK);
    }

    private boolean rungeRule(double int1, double int2, double eps) {
        return Math.abs(int1 - int2) / 3 < eps;
    }

    private double integrate(Equation eq, double[] borders, double h, int steps) throws EssentialDiscontinuityException {
        double point = borders[0];
        double ans = 0;

        double step = Math.abs(borders[0] - borders[1]) / steps;

        while (steps-- > 0) {
            if (Math.abs(point) < 0.00000001) point = 0.0;
            if (isGap(eq, point)) {
                point += 0.000001;
                continue;
            }
            ans += getSquare(eq, new double[]{point, point + step});
            point += step;
        }
        return ans;
    }

    private double getSquare(Equation eq, double[] borders) {
        if (eq.getImage(borders[0]) * eq.getImage(borders[1]) >= 0) {
            return Math.abs(borders[1] - borders[0]) * eq.getImage(borders[0]);
        }
        double t = borders[1];
        if (eq.getImage(t) >= 0) while (eq.getImage(t) > 0) t -= 0.000001;
        else if (eq.getImage(t) < 0) while (eq.getImage(t) < 0) t -= 0.000001;

        return getSquare(eq, new double[]{borders[0], t}) + getSquare(eq, new double[]{t + 0.0000011, borders[1]});
    }
}
