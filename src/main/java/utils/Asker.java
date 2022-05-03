package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Asker {
    private IOutil io;

    public Asker(IOutil io) {
        this.io = io;
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
                "(1) система уравнений\n" +
                "(2) уравнение\n" +
                "(0) выход из приложения\n");
        while (!valid) {
            try {
                mode = Integer.parseInt(getNonEmpty());
                valid = true;
                if (mode < 0 || mode > 2) {
                    io.printError("Такой опции нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return mode;
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
}
