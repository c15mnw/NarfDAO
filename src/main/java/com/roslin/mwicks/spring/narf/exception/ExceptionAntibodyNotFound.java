package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted Antibody is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionAntibodyNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionAntibodyNotFound with the given detail message.
     */
    public ExceptionAntibodyNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionAntibodyNotFound with the given root cause.
     */
    public ExceptionAntibodyNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionAntibodyNotFound with the given detail message and root cause.
     */
    public ExceptionAntibodyNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
