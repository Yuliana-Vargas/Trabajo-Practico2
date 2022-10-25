package customExceptions;

public class ItemRepeatedThreeTimesException extends Exception {
    public ItemRepeatedThreeTimesException(String message){
        super(message);
    }
}
