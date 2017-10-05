package com.roslin.mwicks.spring.narf.exception;

/**
 * This exception is thrown if the wanted Organism is not found.
 * @author Mike Wicks
 */
@SuppressWarnings("serial")
public class ExceptionOrganismNotFound extends Exception {
    // Constructors -------------------------------------------------------------------------------
    /*
     * Constructs an ExceptionOrganismNotFound with the given detail message.
     */
    public ExceptionOrganismNotFound(String message) {

    	super(message);
    }

    /*
     * Constructs an ExceptionOrganismNotFound with the given root cause.
     */
    public ExceptionOrganismNotFound(Throwable cause) {
        
    	super(cause);
    }

    /*
     * Constructs an ExceptionOrganismNotFound with the given detail message and root cause.
     */
    public ExceptionOrganismNotFound(String message, Throwable cause) {
        
    	super(message, cause);
    }

}
