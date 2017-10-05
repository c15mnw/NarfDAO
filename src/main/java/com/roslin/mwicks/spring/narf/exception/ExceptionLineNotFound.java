package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted Line is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionLineNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionLineNotFound with the given detail message.
     */
    public ExceptionLineNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionLineNotFound with the given root cause.
     */
    public ExceptionLineNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionLineNotFound with the given detail message and root cause.
     */
    public ExceptionLineNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
