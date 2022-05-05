package utils;

import equations.EquationManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Asker {
    private IOutil io;
    private EquationManager equationManager;

    public Asker(IOutil io, EquationManager equationManager) {
        this.io = io;
        this.equationManager = equationManager;
    }

    private String getNonEmpty() {
        String str;
        io.printArrow();
        str = io.readLine().trim();
        while (str.equals("")) {
            str = io.readLine().trim();
        }
        return str;
    }

    public int askMode() {
        int mode = 0;
        boolean valid = false;
        io.printDivider();
        io.printText("Выберите задачу:\n" +
                "(1) найти определенный интеграл\n" +
                "(0) выход из приложения\n");
        while (!valid) {
            try {
                mode = Integer.parseInt(getNonEmpty());
                valid = true;
                if (mode < 0 || mode > 1) {
                    io.printError("Такой опции нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return mode;
    }

    public int askEquation(){
        int sysid = 0;
        boolean valid = false;
        io.printText("Выберите уравнение:");
        for(int i = 0; i < equationManager.getAllEqations().size(); ++i){
            System.out.printf("(%d) ", i+1);
            io.printText(equationManager.getAllEqations().get(i).toString());
        }
        io.printText("(0) отмена");
        while (!valid) {
            try {
                sysid = Integer.parseInt(getNonEmpty()) - 1;
                valid = true;
                if (sysid < -1 || sysid >= equationManager.getAllEqations().size()) {
                    io.printError("Такой опции нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return sysid;
    }

    private double askGuess(String var){
        io.printText("Введите нулевое приближение переменной " + var);
        boolean valid = false;
        double guess = 0;
        while (!valid) {
            try {
                guess = Double.parseDouble(getNonEmpty());
                valid = true;
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат числа");
            }
        }
        return guess;
    }

    public double askEps(){
        io.printText("Введите точность");
        boolean valid = false;
        double eps = 0;
        while (!valid) {
            try {
                eps = Double.parseDouble(getNonEmpty());
                valid = true;
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат числа");
            }
        }
        return eps;
    }

    public int askIterations(){
        io.printText("Введите максимальное количество итераций");
        boolean valid = false;
        int iterations = 0;
        while (!valid) {
            try {
                iterations = Integer.parseInt(getNonEmpty());
                valid = true;
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат числа");
            }
        }
        return iterations;
    }

    public double[] askBorders(){
        io.printText("Введите левую границу интегрирования");
        boolean valid = false;
        double a = 0, b = 0;
        while (!valid) {
            try {
                a = Double.parseDouble(getNonEmpty());
                valid = true;
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат числа");
            }
        }
        valid = false;
        io.printText("Введите правую границу интегрирования");
        while (!valid) {
            try {
                b = Double.parseDouble(getNonEmpty());
                if(b > a) valid = true;
                else io.printError("Правая граница должна быть правее левой");
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат числа");
            }
        }
        return new double[]{a, b};
    }
}
