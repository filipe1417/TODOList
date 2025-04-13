package Exception;

public class DuplicatedUsernameException extends RuntimeException {

    public DuplicatedUsernameException(){
        super("User already exist");
    }
}
