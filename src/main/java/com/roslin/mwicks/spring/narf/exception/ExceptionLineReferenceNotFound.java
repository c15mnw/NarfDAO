package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted Line is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionLineReferenceNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionLineNotFound with the given detail message.
     */
    public ExceptionLineReferenceNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionLineNotFound with the given root cause.
     */
    public ExceptionLineReferenceNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionLineNotFound with the given detail message and root cause.
     */
    public ExceptionLineReferenceNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
