/**
 * InvalidPathException.java
 * <p>
 * This exception handler is only suppose to be used for the invalid checks. This just makes my life easier.
 * <p>
 *
 * @author Matthew McLaren
 * @version 06/19/2021
 */
public class InvalidPathException extends Exception {

    public InvalidPathException() {
        super("directory issue");
    }

}
