package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted Antibody is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionAntibodyReferenceNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionAntibodyNotFound with the given detail message.
     */
    public ExceptionAntibodyReferenceNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionAntibodyNotFound with the given root cause.
     */
    public ExceptionAntibodyReferenceNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionAntibodyNotFound with the given detail message and root cause.
     */
    public ExceptionAntibodyReferenceNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
