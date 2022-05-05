package exceptions;

public class EssentialDiscontinuityException extends Exception{
    public EssentialDiscontinuityException(String message, double point){
        super(message + point);
    }
}
