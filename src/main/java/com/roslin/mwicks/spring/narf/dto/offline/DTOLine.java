package com.roslin.mwicks.spring.narf.dto.offline;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import org.hibernate.validator.constraints.NotEmpty;

import com.roslin.mwicks.spring.narf.model.Line;
import com.roslin.mwicks.spring.narf.model.LineMhc;
import com.roslin.mwicks.spring.narf.model.LineResistant;
import com.roslin.mwicks.spring.narf.model.LineSusceptible;
import com.roslin.mwicks.spring.narf.repository.RepositoryLineMhc;
import com.roslin.mwicks.spring.narf.repository.RepositoryLineResistant;
import com.roslin.mwicks.spring.narf.repository.RepositoryLineSusceptible;
import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineMhc;
import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineResistant;
import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineSusceptible;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOLine {
    
    // Constants ----------------------------------------------------------------------------------

	
	// Properties ---------------------------------------------------------------------------------
    @NotEmpty
    private String line;
    private String breed;
    private String origin;    
    private String imported;
    private String mhc;
    private String susceptible;
    private String resistant;
    private String histocompatible;
    private String type;
    @NotEmpty
    private Date creationTime;
    @NotEmpty
    private Date modificationTime;
    @NotEmpty
    private long version;


    // Constructor --------------------------------------------------------------------------------
    public DTOLine() {

    	this.line = "";
    	this.breed = "";
    	this.origin = "";    
    	this.imported = "";
    	this.mhc = "";
    	this.susceptible = "";
    	this.resistant = "";
    	this.histocompatible = "";
    	this.type = "";
    }

    // Getters ------------------------------------------------------------------------------------
    public String getLine() {
    	return this.line;
    }
    public String getBreed() {
    	return this.breed;
    }
    public String getOrigin() {
    	return this.origin;    
    }
    public String getImported() {
    	return this.imported;
    }
    public String getMhc() {
    	return this.mhc;
    }
    public String getSusceptible() {
    	return this.susceptible;
    }
    public String getResistant() {
    	return this.resistant;
    }
    public String getHistocompatible() {
    	return this.histocompatible;
    }
    public String getType() {
    	return this.type;
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
    public void setLine(String line) {
    	this.line = line;
    }
    public void setBreed(String breed) {
    	this.breed = breed;
    }
    public void setOrigin(String origin) {
    	this.origin = origin;    
    }
    public void setImported(String imported) {
    	this.imported = imported;
    }
    public void setMhc(String mhc) {
    	this.mhc = mhc;
    }
    public void setSusceptible(String susceptible) {
    	this.susceptible = susceptible;
    }
    public void setResistant(String resistant) {
    	this.resistant = resistant;
    }
    public void setHistocompatible(String histocompatible) {
    	this.histocompatible = histocompatible;
    }
    public void setType(String type) {
    	this.type = type;
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
     * Is this Line VALID?
     */
    public boolean isThisAValidLine(
    		ServiceLineMhc serviceLineMhc, 
			ServiceLineResistant serviceLineResistant, 
			ServiceLineSusceptible serviceLineSusceptible 
    		){

    	if ( serviceLineMhc.findByName( this.getMhc() ) == null &&
    			serviceLineResistant.findByName( this.getResistant() ) == null && 
    			serviceLineSusceptible.findByName( this.getSusceptible() ) == null ) {
    		
    		return false;
    	}
    	else {
    		
        	return true;
    	}
    }


    /*
     * Convert a DTOLine Object to an Line Object
     */
    public Line convertToLine( 
    		ServiceLineMhc serviceLineMhc, 
			ServiceLineResistant serviceLineResistant, 
			ServiceLineSusceptible serviceLineSusceptible 
			){

    	LineMhc linemhc = serviceLineMhc.findByName( this.getMhc() );
    	LineResistant lineresistant = serviceLineResistant.findByName( this.getResistant() );
    	LineSusceptible linesusceptible = serviceLineSusceptible.findByName( this.getSusceptible() );
    	
    	Line line = Line.getBuilder(
    			null,
        		this.getLine(),
        		this.getBreed(),
        	    this.getOrigin(),
        	    this.getImported(),
        	    linemhc,
        	    linesusceptible,
        	    lineresistant,
        	    this.getHistocompatible(),
        	    this.getType(),
        	    null
        		).build();
        
        return line;
    }

    /*
     * Is this Line VALID?
     */
    public boolean isThisAValidLine(
    		RepositoryLineMhc repositoryLineMhc, 
			RepositoryLineResistant repositoryLineResistant, 
			RepositoryLineSusceptible repositoryLineSusceptible 
    		){

    	if ( repositoryLineMhc.findByName( this.getMhc() ) == null &&
    			repositoryLineResistant.findByName( this.getResistant() ) == null && 
    			repositoryLineSusceptible.findByName( this.getSusceptible() ) == null ) {
    		
    		return false;
    	}
    	else {
    		
        	return true;
    	}
    }


    /*
     * Convert a DTOLine Object to an Line Object
     */
    public Line convertToLine( 
    		RepositoryLineMhc repositoryLineMhc, 
			RepositoryLineResistant repositoryLineResistant, 
			RepositoryLineSusceptible repositoryLineSusceptible 
			){

    	LineMhc linemhc = repositoryLineMhc.findByName( this.getMhc() );
    	LineResistant lineresistant = repositoryLineResistant.findByName( this.getResistant() );
    	LineSusceptible linesusceptible = repositoryLineSusceptible.findByName( this.getSusceptible() );
    	
    	Line line = Line.getBuilder(
    			null,
        		this.getLine(),
        		this.getBreed(),
        	    this.getOrigin(),
        	    this.getImported(),
        	    linemhc,
        	    linesusceptible,
        	    lineresistant,
        	    this.getHistocompatible(),
        	    this.getType(),
        	    null
        		).build();
        
        return line;
    }

    
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }
}
