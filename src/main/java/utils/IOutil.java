package utils;

import methods.MethodResult;
import methods.SolutionStatus;

import java.util.Scanner;

public class IOutil {
    private boolean errsInOut = true;
    private final Scanner scanner;
    private static final double EPS = 0.000001;

    public IOutil() {
        scanner = new Scanner(System.in);
    }

    public void setErrsInOut(boolean errsInOut) {
        this.errsInOut = errsInOut;
    }

    public void printText(String text) {
        System.out.println(text);
    }

    public void printText(String text, int mode) {
        switch (mode) {
            case 1:
                System.out.print(text);
                break;
            default:
                printText(text);
        }
    }

    public void printWarning(String text) {
        System.out.println("\u001B[33m" + text + "\u001B[0m");
    }

    public void printError(String text) {
        if (errsInOut) System.out.println("\u001B[31m" + "Error: " + text + "\u001B[0m");
        else System.err.println(text);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public double readDouble() {
        double a = scanner.nextDouble();
        return a;
    }

    public void printTable(int rows, int columns, double[][] table) {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns - 1; ++j) {
                printDouble(table[i][j]);
            }
            System.out.print("| ");
            printlnDouble(table[i][columns - 1]);
        }
    }

    public void printTable(int rows, int columns, double[][] table, int accuracy) {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns - 1; ++j) {
                printDouble(table[i][j]);
            }
            if (accuracy == 1) System.out.printf("| %20.19f\n", table[i][columns - 1]);
            else System.out.printf("| %5.4f\n", table[i][columns - 1]);
        }
    }

    public void printDouble(double num) {
        if (Math.abs(num) <= EPS) System.out.printf("%10d ", 0);
        else System.out.printf("%10.4f ", num);
    }

    public void printlnDouble(double num) {
        if (Math.abs(num) <= EPS) System.out.printf("%d\n", 0);
        else System.out.printf("%.4f\n", num);
    }

    public void printDivider() {
        System.out.println("------------------------------------------");
    }

    public void printArrow() {
        System.out.print("> ");
    }

    public void printResult(MethodResult res, double eps) {
        int k = 0;

        while (eps < 1) {
            eps *= 10;
            k++;
        }

        if (res.getStatus() == SolutionStatus.OK) {
            System.out.println(res.getStatus().getDescription());
            String s = String.format("%%.%df\n", k+1);
            System.out.printf(s, res.getAnswer());
        } else {
            System.out.println(res.getStatus().getDescription());
        }
    }
}
