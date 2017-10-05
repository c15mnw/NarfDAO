package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted EggOrderLine is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionEggOrderLineNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionEggOrderLineNotFound with the given detail message.
     */
    public ExceptionEggOrderLineNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionEggOrderLineNotFound with the given root cause.
     */
    public ExceptionEggOrderLineNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionEggOrderLineNotFound with the given detail message and root cause.
     */
    public ExceptionEggOrderLineNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
