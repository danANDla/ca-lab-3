package exceptions;

public class UnattainableAccuracyException extends Exception{
    public UnattainableAccuracyException() {
        super("невозможно посчитать интеграл с заданной точностью");
    }
}
