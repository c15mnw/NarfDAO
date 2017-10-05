package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted Order is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionOrderNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionOrderNotFound with the given detail message.
     */
    public ExceptionOrderNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionOrderNotFound with the given root cause.
     */
    public ExceptionOrderNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionOrderNotFound with the given detail message and root cause.
     */
    public ExceptionOrderNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
