package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted Line is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionStrainUseNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionLineNotFound with the given detail message.
     */
    public ExceptionStrainUseNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionLineNotFound with the given root cause.
     */
    public ExceptionStrainUseNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionLineNotFound with the given detail message and root cause.
     */
    public ExceptionStrainUseNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
