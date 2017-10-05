package com.roslin.mwicks.spring.narf.dto.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.roslin.mwicks.spring.narf.model.Strain;
import com.roslin.mwicks.spring.narf.model.StrainUse;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceStrain;
import com.roslin.mwicks.spring.narf.serviceinterface.ServiceStrainUse;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOSearchStrain {
    
    // Constants ----------------------------------------------------------------------------------
	protected static final String SORT_FIELD_NONE = "SORT_FIELD_NONE";

	protected static final String CHICKEN_STRAIN_BLANK = "";
	protected static final String CHICKEN_STRAIN_GFP = "GFP";
	protected static final String CHICKEN_STRAIN_MEMGFP = "MemGFP";
	protected static final String CHICKEN_STRAIN_NOTCH_REPORTER = "Notch reporter";
	protected static final String CHICKEN_STRAIN_CRE_LOX = "Cre-lox";

	protected static final String CHICKEN_STRAIN_USE_BLANK = "";
	protected static final String CHICKEN_STRAIN_USE_C_T = "Cell Tracking";
	protected static final String CHICKEN_STRAIN_USE_F_T = "Fate Tracing";
	protected static final String CHICKEN_STRAIN_USE_GE_P_RT_V = "Gene Expression Pattern Real-Time Visualisation";
	protected static final String CHICKEN_STRAIN_USE_I_O_V = "In-Ovo Visualisation";
	protected static final String CHICKEN_STRAIN_USE_L_M = "Laser Marking";
	protected static final String CHICKEN_STRAIN_USE_L_T = "Lineage Tracing";
	protected static final String CHICKEN_STRAIN_USE_M_V = "Membrane Visualisation";
	protected static final String CHICKEN_STRAIN_USE_N_S_P_RT_V = "Notch Signaling Pattern Real-Time Visualisation";
	protected static final String CHICKEN_STRAIN_USE_S_C_T = "Single Cell Tracking";
	protected static final String CHICKEN_STRAIN_USE_T_G = "Tissue Grafting";

	
	// Properties ---------------------------------------------------------------------------------
    private String strain;
    private String use;


    // Constructor --------------------------------------------------------------------------------
    public DTOSearchStrain() {

    	this.strain = CHICKEN_STRAIN_BLANK;
    	this.use = CHICKEN_STRAIN_USE_BLANK;
    }

    // Getters ------------------------------------------------------------------------------------
    public String getStrain() {
    	return this.strain;
    }
    public String getUse() {
    	return this.use;
    }

    
    // Setters ------------------------------------------------------------------------------------
    public void setStrain(String strain) {
    	this.strain = strain;
    }
    public void setUse(String use) {
    	this.use = use;
    }
    

    // Getters As Required DataTypes --------------------------------------------------------------

    // Setters From Strings -----------------------------------------------------------------------
    
    // Check for Required DataTypes ---------------------------------------------------------------


    // Helpers ------------------------------------------------------------------------------------    
    public boolean isStrainBlank() {
    	if ( this.strain.equals(CHICKEN_STRAIN_BLANK)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainGfp() {
    	if ( this.strain.equals(CHICKEN_STRAIN_GFP)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainMemGfp() {
    	if ( this.strain.equals(CHICKEN_STRAIN_MEMGFP)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainNotchReporter() {
    	if ( this.strain.equals(CHICKEN_STRAIN_NOTCH_REPORTER)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainCreLox() {
    	if ( this.strain.equals(CHICKEN_STRAIN_CRE_LOX)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean isStrainUseBlank() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_BLANK)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseCellTracking() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_C_T)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseFateTracing() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_F_T)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseGeneExpressionPatternRealTimeVisualisation() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_GE_P_RT_V)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseInOvoVisualisation() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_I_O_V)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseLaserMarking() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_L_M)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseLineageTracing() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_L_T)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseMembraneVisualisation() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_M_V)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseNotchSignalingPatternRealTimeVisualisation() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_N_S_P_RT_V)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseSingleCellTracking() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_S_C_T)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isStrainUseTissueGrafting() {
    	if ( this.use.equals(CHICKEN_STRAIN_USE_T_G)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean isValidStrain() {
    	if ( this.isStrainBlank() ||
    			this.isStrainGfp() ||
    			this.isStrainMemGfp() ||
    			this.isStrainNotchReporter() ||
    			this.isStrainCreLox() ) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean isValidStrainUse() {
    	if ( this.isStrainUseBlank() ||
    			this.isStrainUseCellTracking() ||
    			this.isStrainUseFateTracing() ||
    			this.isStrainUseGeneExpressionPatternRealTimeVisualisation() ||
    			this.isStrainUseInOvoVisualisation() ||
    			this.isStrainUseLaserMarking() ||
    			this.isStrainUseLineageTracing() ||
    			this.isStrainUseMembraneVisualisation() ||
    			this.isStrainUseNotchSignalingPatternRealTimeVisualisation() ||
    			this.isStrainUseSingleCellTracking() ||
    			this.isStrainUseTissueGrafting() ) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    
    /*
     * Is this Strain VALID?
     */
    public boolean isThisAValidSearchStrain(
    		){

    	if ( this.isValidStrain() &&
    			this.isValidStrainUse() ) {
    		
    		return true;
    	}
    	else {
    		
        	return false;
    	}
    }

    
    public List<Strain> searchForStrains( ServiceStrain servicestrain, ServiceStrainUse servicestrainuse  ){

        List<Strain> searchs = new ArrayList<Strain>();

    	if ( this.isStrainBlank() &&
    			!this.isStrainUseBlank() ) {
    		
    		StrainUse strainuse = servicestrainuse.findByUse( this.getUse() );

            searchs = servicestrain.findAllByStrainUse( strainuse );
    	}
    	else {
        	if ( !this.isStrainBlank() &&
        			this.isStrainUseBlank() ) {
        		
                searchs = servicestrain.findAllByStrain( this.getStrain() );
        	}
        	else {
        		
        		StrainUse strainuse = servicestrainuse.findByUse( this.getUse() );
        		
                searchs = servicestrain.findAllByStrainAndStrainUse( this.getStrain(), strainuse );
        	}
    	}

        Collections.sort(searchs, new Strain.OrderByStrainAsc());
    	
    	return searchs;
    }
    
    
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }
}
