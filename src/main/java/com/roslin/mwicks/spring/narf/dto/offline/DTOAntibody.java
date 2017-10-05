package com.roslin.mwicks.spring.narf.dto.offline;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import org.hibernate.validator.constraints.NotEmpty;

import com.roslin.mwicks.spring.narf.model.Antibody;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOAntibody {
    
    // Constants ----------------------------------------------------------------------------------

	
	// Properties ---------------------------------------------------------------------------------
    @NotEmpty
    private String name;
    private String antigen;
    private String antigenSearch;
    private String isotype;
    private String species;
    private String application;
    private String supplier;
    private String productCode;
    private String website;
    @NotEmpty
    private Date creationTime;
    @NotEmpty
    private Date modificationTime;
    @NotEmpty
    private long version;


    // Constructor --------------------------------------------------------------------------------
    public DTOAntibody() {

    	this.name = "";
    	this.antigen = "";
    	this.antigenSearch = "";    
    	this.isotype = "";
    	this.species = "";
    	this.application = "";
    	this.supplier = "";
    	this.productCode = "";
    	this.website = "";
    }

    // Getters ------------------------------------------------------------------------------------
    public String getName() {
    	return this.name;
    }
    public String getAntigen() {
    	return this.antigen;
    }
    public String getAntigenSearch() {
    	return this.antigenSearch;    
    }
    public String getIsotype() {
    	return this.isotype;
    }
    public String getSpecies() {
    	return this.species;
    }
    public String getApplication() {
    	return this.application;
    }
    public String getSupplier() {
    	return this.supplier;
    }
    public String getProductCode() {
    	return this.productCode;
    }
    public String getWebsite() {
    	return this.website;
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
    public void setAntigen(String antigen) {
    	this.antigen = antigen;
    }
    public void setAntigenSearch(String antigenSearch) {
    	this.antigenSearch = antigenSearch;    
    }
    public void setIsotype(String isotype) {
    	this.isotype = isotype;
    }
    public void setSpecies(String species) {
    	this.species = species;
    }
    public void setApplication(String application) {
    	this.application = application;
    }
    public void setSupplier(String supplier) {
    	this.supplier = supplier;
    }
    public void setProductCode(String productCode) {
    	this.productCode = productCode;
    }
    public void setWebsite(String website) {
    	this.website = website;
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
     * Is this Antibody VALID?
     */
    public boolean isThisAValidAntibody(){

    	return true;
    }


    /*
     * Convert a DTOAntibody Object to an Antibody Object
     */
    public Antibody convertToAntibody(){

    	Antibody antibody = Antibody.getBuilder(
    			null,
        		this.getName(),
        		this.getAntigen(),
        	    this.getAntigenSearch(),
        	    this.getIsotype(),
        	    this.getSpecies(),
        	    this.getApplication(),
        	    this.getSupplier(),
        	    this.getProductCode(),
        	    this.getWebsite(),
        	    null
        		).build();
        
        return antibody;
    }

    
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }
}
