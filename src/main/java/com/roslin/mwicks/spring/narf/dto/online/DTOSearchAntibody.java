package com.roslin.mwicks.spring.narf.dto.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.roslin.mwicks.spring.narf.model.Antibody;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceAntibody;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOSearchAntibody {
    
    // Constants ----------------------------------------------------------------------------------
	protected static final String SORT_FIELD_NONE = "SORT_FIELD_NONE";

	protected static final String ANTIGEN_BLANK = "";
	protected static final String ANTIGEN_CD44 = "CD44";
	protected static final String ANTIGEN_CD28 = "CD28";
	protected static final String ANTIGEN_CD08_ALPHA = "CD8&#x3B1";
	protected static final String ANTIGEN_BU1 = "Bu-1";
	protected static final String ANTIGEN_CD04 = "CD4";
	protected static final String ANTIGEN_TCR_ALPHA = "TCR &#x3B1";
	protected static final String ANTIGEN_CD03 = "CD3";
	protected static final String ANTIGEN_IL02 = "IL-2";
	protected static final String ANTIGEN_IL06 = "IL-6";
	protected static final String ANTIGEN_BMDC = "BM-DC";
	protected static final String ANTIGEN_IL12_BETA = "IL-12&#x3B2";
	protected static final String ANTIGEN_CD34 = "CD34";
	protected static final String ANTIGEN_CD14 = "CD14";
	protected static final String ANTIGEN_CD25 = "CD25";
	protected static final String ANTIGEN_TIM4L = "Tim4L";
	protected static final String ANTIGEN_TIM4 = "Tim4";
	protected static final String ANTIGEN_IL10 = "IL-10";
	protected static final String ANTIGEN_IL04 = "IL-4";
	protected static final String ANTIGEN_CSF1R = "CSF1R";

	
	// Properties ---------------------------------------------------------------------------------
    private String antigen;


    // Constructor --------------------------------------------------------------------------------
    public DTOSearchAntibody() {

    	this.antigen = "";
    }

    // Getters ------------------------------------------------------------------------------------
    public String getAntigen() {
    	return this.antigen;
    }

    
    // Setters ------------------------------------------------------------------------------------
    public void setAntigen(String antigen) {
    	this.antigen = antigen;
    }
    

    // Getters As Required DataTypes --------------------------------------------------------------

    // Setters From Strings -----------------------------------------------------------------------
    // Check for Required DataTypes ---------------------------------------------------------------


    // Helpers ------------------------------------------------------------------------------------    
    public boolean isAntigenBlank() {
    	if ( this.antigen.equals(ANTIGEN_BLANK)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenCD44() {
    	if ( this.antigen.equals(ANTIGEN_CD44)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenCD28() {
    	if ( this.antigen.equals(ANTIGEN_CD28)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenCD08ALPHA() {
    	if ( this.antigen.equals(ANTIGEN_CD08_ALPHA)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenBU1() {
    	if ( this.antigen.equals(ANTIGEN_BU1)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenCD04() {
    	if ( this.antigen.equals(ANTIGEN_CD04)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenTCRALPHA() {
    	if ( this.antigen.equals(ANTIGEN_TCR_ALPHA)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenCD03() {
    	if ( this.antigen.equals(ANTIGEN_CD03)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenIL02() {
    	if ( this.antigen.equals(ANTIGEN_IL02)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenIL06() {
    	if ( this.antigen.equals(ANTIGEN_IL06)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenBMDC() {
    	if ( this.antigen.equals(ANTIGEN_BMDC)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenIL12BETA() {
    	if ( this.antigen.equals(ANTIGEN_IL12_BETA)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenCD34() {
    	if ( this.antigen.equals(ANTIGEN_CD34)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenCD14() {
    	if ( this.antigen.equals(ANTIGEN_CD14)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenCD25() {
    	if ( this.antigen.equals(ANTIGEN_CD25)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenTIM4L() {
    	if ( this.antigen.equals(ANTIGEN_TIM4L)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenTIM4() {
    	if ( this.antigen.equals(ANTIGEN_TIM4)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenIL10() {
    	if ( this.antigen.equals(ANTIGEN_IL10)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenIL04() {
    	if ( this.antigen.equals(ANTIGEN_IL04)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isAntigenCSF1R() {
    	if ( this.antigen.equals(ANTIGEN_CSF1R)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }


    public boolean isValidAntigen() {
    	if ( this.isAntigenBlank() || 
    			this.isAntigenCD44() || 
    			this.isAntigenCD28() || 
    			this.isAntigenCD08ALPHA() || 
    			this.isAntigenBU1() || 
    			this.isAntigenCD04() || 
    			this.isAntigenTCRALPHA() || 
    			this.isAntigenCD03() || 
    			this.isAntigenIL02() || 
    			this.isAntigenIL06() || 
    			this.isAntigenBMDC() || 
    			this.isAntigenIL12BETA() || 
    			this.isAntigenCD34() || 
    			this.isAntigenCD14() || 
    			this.isAntigenCD25() || 
    			this.isAntigenTIM4L() || 
    			this.isAntigenTIM4() || 
    			this.isAntigenIL10() || 
    			this.isAntigenIL04() || 
    			this.isAntigenCSF1R() ) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }


    /*
     * Is this Antibody VALID?
     */
    public boolean isThisAValidSearchAntibody(
    		){

    	if ( this.isValidAntigen() ) {
    		
    		return true;
    	}
    	else {
    		
        	return false;
    	}
    }

    
    public List<Antibody> searchForAntibodies( ServiceAntibody serviceantibody ){

        List<Antibody> searchAntibodys = new ArrayList<Antibody>();

        searchAntibodys = serviceantibody.findAllByAntigen( this.getAntigen() );

    	Collections.sort(searchAntibodys, new Antibody.OrderByNameAsc());
    	
    	return searchAntibodys;
    }

    
    
    
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }
}
