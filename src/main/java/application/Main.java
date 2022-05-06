package application;

import equations.EquationManager;
import methods.LeftRect;
import methods.MethodResult;
import methods.MidRect;
import methods.RightRect;
import utils.Asker;
import utils.IOutil;

public class Main {
    public static void main(String[] args) {
        IOutil io = new IOutil();
        EquationManager equationManager = new EquationManager();
        Asker asker = new Asker(io, equationManager);
        LeftRect leftRect = new LeftRect(equationManager, false);
        RightRect rightRect = new RightRect(equationManager, false);
        MidRect midRect = new MidRect(equationManager, false);


        boolean running = true;
        while (running) {
            int mode = asker.askMode();
            switch (mode) {
                case (1): {
                    int eqid = asker.askEquation();
                    if (eqid == -1) break;
                    double[] borders = asker.askBorders();
                    double eps = asker.askEps();

                    int steps = 0;

                    io.printWarning("Метод левых прямоугольников");
                    try {
                        steps = leftRect.GetSteps(eqid, borders, eps);
                        MethodResult leftRes = leftRect.solveEquation(eqid, borders, steps);
                        io.printResult(leftRes, eps);
                        io.printText("Количество разбиений: " + steps);
                    } catch (Exception e) {
                        io.printError(e.getMessage());
                        continue;
                    }
                    io.printText("");

                    io.printWarning("Метод правых прямоугольников");
                    try {
                        steps = rightRect.GetSteps(eqid, borders, eps);
                        MethodResult rightRes = rightRect.solveEquation(eqid, borders, steps);
                        io.printResult(rightRes, eps);
                        io.printText("Количество разбиений: " + steps);
                    } catch (Exception e) {
                        io.printError(e.getMessage());
                        continue;
                    }
                    io.printText("");

                    io.printWarning("Метод средних прямоугольников");
                    try {
                        steps = midRect.GetSteps(eqid, borders, eps);
                        MethodResult midRes = midRect.solveEquation(eqid, borders, steps);
                        io.printResult(midRes, eps);
                        io.printText("Количество разбиений: " + steps);
                    } catch (Exception e) {
                        io.printError(e.getMessage());
                    }
                    break;
                }
                case (0): {
                    running = false;
                    break;
                }
            }
        }
    }
}
