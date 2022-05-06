package application;

import equations.EquationManager;
import methods.LeftRect;
import methods.MethodResult;
import methods.SolutionStatus;
import utils.Asker;
import utils.IOutil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        IOutil io = new IOutil();
        EquationManager equationManager = new EquationManager();
        Asker asker = new Asker(io, equationManager);
        LeftRect leftRect = new LeftRect(equationManager);


        boolean running = true;
        while (running) {
            int mode = asker.askMode();
            switch (mode) {
                case (1): {
                    int eqid = asker.askEquation();
                    if (eqid == -1) break;
                    double[] borders = asker.askBorders();
                    double eps = asker.askEps();
                    try {
                        MethodResult leftRes = leftRect.solveEquation(eqid, borders, eps);
                        io.printResult(leftRes);
                    } catch (Exception e){
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
