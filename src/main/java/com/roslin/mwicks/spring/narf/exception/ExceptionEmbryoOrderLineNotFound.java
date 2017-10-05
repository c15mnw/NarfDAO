package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted EmbryoOrderLine is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionEmbryoOrderLineNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionEmbryoOrderLineNotFound with the given detail message.
     */
    public ExceptionEmbryoOrderLineNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionEmbryoOrderLineNotFound with the given root cause.
     */
    public ExceptionEmbryoOrderLineNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionEmbryoOrderLineNotFound with the given detail message and root cause.
     */
    public ExceptionEmbryoOrderLineNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
