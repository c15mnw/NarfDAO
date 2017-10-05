package com.roslin.mwicks.spring.narf.dto.offline;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import org.hibernate.validator.constraints.NotEmpty;

import com.roslin.mwicks.spring.narf.model.Organism;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOOrganism {
    
    // Constants ----------------------------------------------------------------------------------

	
	// Properties ---------------------------------------------------------------------------------
    @NotEmpty
    private String name;
    @NotEmpty
    private Date creationTime;
    @NotEmpty
    private Date modificationTime;
    @NotEmpty
    private long version;


    // Constructor --------------------------------------------------------------------------------
    public DTOOrganism() {

    	this.name = "";
    }

    // Getters ------------------------------------------------------------------------------------
    public String getName() {
    	return this.name;
    }
    
    public Date getCreationTime() {
    	return this.creationTime;
    }
    public Date getModificationTime() {
    	return this.modificationTime;
    }
    public long getVersion() {
        return this.version;
    }
    
    
    // Setters ------------------------------------------------------------------------------------
    public void setName(String name) {
    	this.name = name;
    }

    public void setCreationTime(Date creationTime) {
    	this.creationTime = creationTime;
    }
    public void setModificationTime(Date modificationTime) {
    	this.modificationTime = modificationTime;
    }
    public void setVersion(long version) {
    	this.version = version;
    }
    

    // Getters As Required DataTypes --------------------------------------------------------------
    public String getCreationTimeAsString() {
    	return ObjectConverter.convert(this.creationTime, String.class);
    }
    public String getModificationTimeAsString() {
    	return ObjectConverter.convert(this.modificationTime, String.class);
    }
    public String getVersionAsString() {
    	return ObjectConverter.convert(this.version, String.class);
    }


    // Setters From Strings -----------------------------------------------------------------------
    public void setCreationTimeFromString(String creationTime) {
    	this.creationTime = ObjectConverter.convert(creationTime, Date.class);
    }
    public void setModificationTimeFromString(String modificationTime) {
    	this.modificationTime = ObjectConverter.convert(modificationTime, Date.class);
    }

    
    // Check for Required DataTypes ---------------------------------------------------------------


    // Helpers ------------------------------------------------------------------------------------    
    /*
     * Is this Organism VALID?
     */
    public boolean isThisAValidOrganism(){

    	if ( this.getName().equals("") ) {
    		
    		return false;
    	}
    	else {
    		
        	return true;
    	}
    }


    /*
     * Convert a DTOOrganism Object to an Organism Object
     */
    public Organism convertToOrganism(){

    	
    	Organism organism = Organism.getBuilder(
    			null,
        		this.getName(),
        	    null,
        	    null,
        	    null
        		).build();
        
        return organism;
    }


    
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }
}
