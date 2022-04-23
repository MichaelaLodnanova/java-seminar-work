package cz.muni.fi.pb162.project.exception;

/**
 * Class checks drawing in the same color on the same background
 * @author Michaela Lodnanova
 */
public class TransparentColorException extends Exception{

    /**
     * First constructor sets string with an error message
     * @param message represents error message
     */
    public TransparentColorException(String message){
        super(message);
    }

    /**
     * Second constructor sets string with an error message
     * and allows setting string and the cause of the exception
     * @param message represents error message
     * @param cause the exception that was the immediate cause
     */
    public TransparentColorException(String message, Throwable cause){
        super(message, cause);
    }
}
