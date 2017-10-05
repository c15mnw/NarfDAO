package com.roslin.mwicks.spring.narf.dto.offline;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import org.hibernate.validator.constraints.NotEmpty;

import com.roslin.mwicks.spring.narf.model.LineReference;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOLineReference {
    
    // Constants ----------------------------------------------------------------------------------

	
	// Properties ---------------------------------------------------------------------------------
    @NotEmpty
    private String reference;
    private String url;
    @NotEmpty
    private Date creationTime;
    @NotEmpty
    private Date modificationTime;
    @NotEmpty
    private long version;


    // Constructor --------------------------------------------------------------------------------
    public DTOLineReference() {

    	this.reference = "";
    	this.url = "";
    }

    // Getters ------------------------------------------------------------------------------------
    public String getReference() {
    	return this.reference;
    }
    public String getUrl() {
    	return this.url;
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
    public void setReference(String reference) {
    	this.reference = reference;
    }
    public void setUrl(String url) {
    	this.url = url;
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
     * Is this LineReference VALID?
     */
    public boolean isThisAValidLineReference(){

    	return true;
    }


    /*
     * Convert a DTOLineReference Object to an LineReference Object
     */
    public LineReference convertToLineReference(){

    	LineReference line = LineReference.getBuilder(
    			null,
        		this.getReference(),
        		this.getUrl()
        		).build();
        
        return line;
    }

    
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }
}
