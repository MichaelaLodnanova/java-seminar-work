package cz.muni.fi.pb162.project.exception;

/**
 * Class represents the unchecked exception when there are not
 * enough vertices in the collection
 * @author Michaela Lodnanova
 */
public class MissingVerticesException extends RuntimeException{

    /**
     * First constructor sets string with an error message
     * @param message represents error message
     */
    public MissingVerticesException(String message){
        super(message);
    }

    /**
     * Second constructor sets string with an error message
     * and allows setting string and the cause of the exception
     * @param message represents error message
     * @param cause the exception that was the immediate cause
     */
    public MissingVerticesException(String message, Throwable cause){
        super(message, cause);
    }
}
