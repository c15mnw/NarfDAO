package com.roslin.mwicks.spring.narf.dto.offline;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import org.hibernate.validator.constraints.NotEmpty;

import com.roslin.mwicks.spring.narf.model.Strain;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOStrain {
    
    // Constants ----------------------------------------------------------------------------------

	
	// Properties ---------------------------------------------------------------------------------
    @NotEmpty
    private String strain;
    @NotEmpty
    private String strainLong;
    @NotEmpty
    private String protein;
    @NotEmpty
    private String spectra;
    @NotEmpty
    private String pattern;
    @NotEmpty
    private String availability;
    @NotEmpty
    private String description;
    @NotEmpty
    private String contact;
    @NotEmpty
    private String price;
    @NotEmpty
    private Date creationTime;
    @NotEmpty
    private Date modificationTime;
    @NotEmpty
    private long version;


    // Constructor --------------------------------------------------------------------------------
    public DTOStrain() {

    	this.strain = "";
    	this.strainLong = "";
    	this.protein = "";
    	this.spectra = "";
    	this.pattern = "";
    	this.availability = "";
    	this.description = "";
    	this.contact = "";
    	this.price = "";
    }

    // Getters ------------------------------------------------------------------------------------
    public String getStrain() {
    	return this.strain;
    }
    public String getStrainLong() {
    	return this.strainLong;
    }
    public String getProtein() {
    	return this.protein;
    }
    public String getSpectra() {
    	return this.spectra;
    }
    public String getPattern() {
    	return this.pattern;
    }
    public String getAvailability() {
    	return this.availability;
    }
    public String getDescription() {
    	return this.description;
    }
    public String getContact() {
    	return this.contact;
    }
    public String getPrice() {
    	return this.price;
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
    public void setStrain(String strain) {
    	this.strain = strain;
    }
    public void setStrainLong(String strainLong) {
    	this.strainLong = strainLong;
    }
    public void setProtein(String protein) {
    	this.protein = protein;
    }
    public void setSpectra(String spectra) {
    	this.spectra = spectra;
    }
    public void setPattern(String pattern) {
    	this.pattern = pattern;
    }
    public void setAvailability(String availability) {
    	this.availability = availability;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    public void setContact(String contact) {
    	this.contact = contact;
    }
    public void setPrice(String price) {
    	this.price = price;
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
     * Is this Strain VALID?
     */
    public boolean isThisAValidStrain(){

    	return true;
    }


    /*
     * Convert a DTOStrain Object to an Strain Object
     */
    public Strain convertToStrain(){

    	Strain strain = Strain.getBuilder(
    			null,
            	this.getStrain(),
            	this.getStrainLong(),
            	this.getProtein(),
            	this.getSpectra(),
            	this.getPattern(),
            	this.getAvailability(),
            	this.getDescription(),
            	this.getContact(),
            	this.getPrice(),
    			null,
    			null
        		).build();
        
        return strain;
    }

    
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }
}
