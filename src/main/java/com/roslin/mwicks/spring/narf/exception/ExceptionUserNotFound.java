package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted User is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionUserNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionUserNotFound with the given detail message.
     */
    public ExceptionUserNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionUserNotFound with the given root cause.
     */
    public ExceptionUserNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionUserNotFound with the given detail message and root cause.
     */
    public ExceptionUserNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
