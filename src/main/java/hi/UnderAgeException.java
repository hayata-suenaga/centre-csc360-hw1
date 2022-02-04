package hi;

public class UnderAgeException extends Exception {
    public UnderAgeException() {
        super("Too young to have kids");
    }
}
