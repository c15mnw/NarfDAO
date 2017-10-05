package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted Avian is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionAvianNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionAvianNotFound with the given detail message.
     */
    public ExceptionAvianNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionAvianNotFound with the given root cause.
     */
    public ExceptionAvianNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionAvianNotFound with the given detail message and root cause.
     */
    public ExceptionAvianNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
