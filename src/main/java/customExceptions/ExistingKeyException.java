package customExceptions;

public class ExistingKeyException extends Exception{
    public ExistingKeyException(String message){
        super(message);
    }
}
