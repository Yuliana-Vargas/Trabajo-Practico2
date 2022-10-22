package customExceptions;

public class RemoveItemWithNonExistentKeyException extends Exception{
    public RemoveItemWithNonExistentKeyException(String message){
        super(message);
    }
}
