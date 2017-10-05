package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted BirdOrderLine is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionBirdOrderLineNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionBirdOrderLineNotFound with the given detail message.
     */
    public ExceptionBirdOrderLineNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionBirdOrderLineNotFound with the given root cause.
     */
    public ExceptionBirdOrderLineNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionBirdOrderLineNotFound with the given detail message and root cause.
     */
    public ExceptionBirdOrderLineNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
