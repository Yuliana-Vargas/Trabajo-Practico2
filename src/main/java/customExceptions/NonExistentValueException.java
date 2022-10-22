package customExceptions;

public class NonExistentValueException extends Exception{
    public NonExistentValueException(String message){
        super(message);
    }
}
