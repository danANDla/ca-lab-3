package equations;

import java.util.HashMap;

public interface Equation {
    Double getImage(double v);
    Double get1Derivative(double v);
    Double get2Derivative(double v);

    String ToString();
    default double getSecondDerivativeMaxValue(double[] borders) {
        Double max = Math.abs(this.get2Derivative(borders[0]));
        if (max.isInfinite()) {
            max = Math.abs(this.get2Derivative(borders[0] + 0.01));
        }
        double x_0 = borders[0];
        while (x_0 < borders[1]) {
            if (Math.abs(x_0 - 0) < 0.0001) {
                x_0 = 0;
            }
            if (x_0 == borders[0]) {
                x_0 += 0.1;
                continue;
            }
            if (Double.isInfinite(this.get2Derivative(x_0)) || Double.isNaN(this.get2Derivative(x_0))) {
                x_0 += 0.1;
                continue;
            }
            if (Math.abs(this.get2Derivative(x_0)) > max) {
                max = Math.abs(this.get2Derivative(x_0));
            }
            x_0 += 0.1;
        }
        return max;
    }

    default int getAmountOnSegment(double[] borders, double accuracy, double maxSecondDerivativeValue) {
        double result = Math.sqrt((maxSecondDerivativeValue * Math.pow((borders[1] - borders[0]), 3)) / (12 * accuracy));
        if (Math.abs(result - (int) result) < 0.000001) return (int) result;
        else return (int) result + 1;
    }
}
