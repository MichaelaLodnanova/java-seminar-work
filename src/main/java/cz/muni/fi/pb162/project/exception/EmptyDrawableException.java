package cz.muni.fi.pb162.project.exception;

/**
 * Class EmptyDrawableException checks when there is nothing painted
 * on the drawing object
 * @author Michaela Lodnanova
 */
public class EmptyDrawableException extends Exception{

    /**
     * First constructor sets string with an error message
     * @param message represents error message
     */
    public EmptyDrawableException(String message){
        super(message);
    }

    /**
     * Second constructor sets string with an error message
     * and allows setting string and the cause of the exception
     * @param message represents error message
     * @param cause the exception that was the immediate cause
     */
    public EmptyDrawableException(String message, Throwable cause){
        super(message, cause);
    }
}
