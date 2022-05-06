package application;

import equations.EquationManager;
import methods.LeftRect;
import methods.MethodResult;
import utils.Asker;
import utils.IOutil;

public class Main {
    public static void main(String[] args) {
        IOutil io = new IOutil();
        EquationManager equationManager = new EquationManager();
        Asker asker = new Asker(io, equationManager);
        LeftRect leftRect = new LeftRect(equationManager, false);


        boolean running = true;
        while (running) {
            int mode = asker.askMode();
            switch (mode) {
                case (1): {
                    int eqid = asker.askEquation();
                    if (eqid == -1) break;
                    double[] borders = asker.askBorders();
                    double eps = asker.askEps();

                    io.printWarning("Метод левых прямоугольников");
                    try {
                        int steps = leftRect.GetSteps(eqid, borders, eps);
                        MethodResult leftRes = leftRect.solveEquation(eqid, borders, steps);
                        io.printResult(leftRes, eps);
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
