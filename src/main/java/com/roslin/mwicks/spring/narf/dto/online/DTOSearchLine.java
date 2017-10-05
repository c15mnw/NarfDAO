package com.roslin.mwicks.spring.narf.dto.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.roslin.mwicks.spring.narf.model.Line;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLine;

import com.roslin.mwicks.spring.narf.enums.EnumMhc;
import com.roslin.mwicks.spring.narf.enums.EnumResistant;
import com.roslin.mwicks.spring.narf.enums.EnumSusceptible;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 * @author Mike Wicks
 */
public class DTOSearchLine {
    
    // Constants ----------------------------------------------------------------------------------
	protected static final String SORT_FIELD_NONE = "SORT_FIELD_NONE";

	protected static final String MHC_BLANK = "";
	protected static final String MHC_B2 = "B<sup>2</sup>";
	protected static final String MHC_B4 = "B<sup>4</sup>/B<sup>4</sup>, B<sup>12</sup>/B<sup>12</sup>, B<sup>4</sup>/B<sup>12</sup>";
	protected static final String MHC_B14 = "B<sup>14</sup>";
	protected static final String MHC_B15 = "B<sup>15</sup>";
	protected static final String MHC_B19 = "B<sup>19</sup>";
	protected static final String MHC_B21 = "B<sup>21</sup>";
	protected static final String MHC_B132 = "B<sup>132, 133, 134, 135</sup>";
	protected static final String MHC_B142 = "B<sup>142, 143, 144</sup>";

	protected static final String SUSCEPTIBLE_BLANK = "";
	protected static final String SUSCEPTIBLE_LVV_ABCD = "LLV subgroups A, B, C, D";
	protected static final String SUSCEPTIBLE_LVV_ABDE = "LLV subgroups A, B, D, E";
	protected static final String SUSCEPTIBLE_LLV_AC = "LLV subgroups A, C; segregating for B, D, E. Moderately susceptible to MDV";
	protected static final String SUSCEPTIBLE_LLV_BCD = "LLV subgroups B, C, D";
	protected static final String SUSCEPTIBLE_MDV = "MDV";
	protected static final String SUSCEPTIBLE_MDV_EIMERIA = "MDV, embryos susceptible to Eimeria sp.";
	protected static final String SUSCEPTIBLE_MDV_BCD = "LLV subgroups B, C, D (not A, E) and to Eimeria sp.";

	protected static final String RESISTANT_BLANK = "";
	protected static final String RESISTANT_LLVTUMOUR = "MDV, LLV tumour development";
	protected static final String RESISTANT_MDV = "MDV";
	protected static final String RESISTANT_LLVSUBGROUP = "LLV subgroups B and D (mostly), segregating for A and E. Hatched birds resistant to Eimeria sp.";

	
	// Properties ---------------------------------------------------------------------------------
    private EnumMhc mhc;
    private EnumSusceptible susceptible;
    private EnumResistant resistant;


    // Constructor --------------------------------------------------------------------------------
    public DTOSearchLine() {

    	this.mhc = EnumMhc.BLANK;
    	this.susceptible = EnumSusceptible.BLANK;
    	this.resistant = EnumResistant.BLANK;
    }

    // Getters ------------------------------------------------------------------------------------
    public EnumMhc getMhc() {
    	return this.mhc;
    }
    public EnumSusceptible getSusceptible() {
    	return this.susceptible;
    }
    public EnumResistant getResistant() {
    	return this.resistant;
    }

    
    // Setters ------------------------------------------------------------------------------------
    public void setMhc(EnumMhc mhc) {
    	this.mhc = mhc;
    }
    public void setSusceptible(EnumSusceptible susceptible) {
    	this.susceptible = susceptible;
    }
    public void setResistant(EnumResistant resistant) {
    	this.resistant = resistant;
    }
    

    // Getters As Required DataTypes --------------------------------------------------------------
    public String getMhcAsString() {

        String rtnString = "";

        if ( this.mhc.equals(EnumMhc.BLANK)) {
            rtnString = MHC_BLANK;
    	}
    	if ( this.mhc.equals(EnumMhc.B2)) {
            rtnString = MHC_B2;
    	}
    	if ( this.mhc.equals(EnumMhc.B4)) {
            rtnString = MHC_B4;
    	}
    	if ( this.mhc.equals(EnumMhc.B14)) {
            rtnString = MHC_B14;
    	}
    	if ( this.mhc.equals(EnumMhc.B15)) {
            rtnString = MHC_B15;
    	}
    	if ( this.mhc.equals(EnumMhc.B19)) {
            rtnString = MHC_B19;
    	}
    	if ( this.mhc.equals(EnumMhc.B21)) {
            rtnString = MHC_B21;
    	}
    	if ( this.mhc.equals(EnumMhc.B132)) {
            rtnString = MHC_B132;
    	}
    	if ( this.mhc.equals(EnumMhc.B142)) {
            rtnString = MHC_B142;
    	}
    	
    	return rtnString;
    }

    public String getSusceptibleAsString() {

        String rtnString = "";
        
        if ( this.susceptible.equals(EnumSusceptible.BLANK)) {
            rtnString = SUSCEPTIBLE_BLANK;
    	}
    	if ( this.susceptible.equals(EnumSusceptible.LVV_ABCD)) {
            rtnString = SUSCEPTIBLE_LVV_ABCD;
    	}
    	if ( this.susceptible.equals(EnumSusceptible.LVV_ABDE)) {
            rtnString = SUSCEPTIBLE_LVV_ABDE;
    	}
    	if ( this.susceptible.equals(EnumSusceptible.LLV_AC)) {
            rtnString = SUSCEPTIBLE_LLV_AC;
    	}
    	if ( this.susceptible.equals(EnumSusceptible.LLV_BCD)) {
            rtnString = SUSCEPTIBLE_LLV_BCD;
    	}
    	if ( this.susceptible.equals(EnumSusceptible.MDV)) {
            rtnString = SUSCEPTIBLE_MDV;
    	}
    	if ( this.susceptible.equals(EnumSusceptible.MDV_EIMERIA)) {
            rtnString = SUSCEPTIBLE_MDV_EIMERIA;
    	}
    	if ( this.susceptible.equals(EnumSusceptible.MDV_BCD)) {
            rtnString = SUSCEPTIBLE_MDV_BCD;
    	}
    	
    	return rtnString;
    }

    public String getResistantAsString() {

        String rtnString = "";
        
        if ( this.resistant.equals(EnumResistant.BLANK)) {
            rtnString = RESISTANT_BLANK;
    	}
    	if ( this.resistant.equals(EnumResistant.LLVTUMOUR)) {
            rtnString = RESISTANT_LLVTUMOUR;
    	}
    	if ( this.resistant.equals(EnumResistant.MDV)) {
            rtnString = RESISTANT_MDV;
    	}
    	if ( this.resistant.equals(EnumResistant.LLVSUBGROUP)) {
            rtnString = RESISTANT_LLVSUBGROUP;
    	}
    	
    	return rtnString;
    }


    // Setters From Strings -----------------------------------------------------------------------
    public void setMhc(String mhc) {
    	
    	if ( mhc.equals(MHC_BLANK)) {
            this.mhc = EnumMhc.BLANK;
    	}
    	if ( mhc.equals(MHC_B2)) {
            this.mhc = EnumMhc.B2;
    	}
    	if ( mhc.equals(MHC_B4)) {
            this.mhc = EnumMhc.B4;
    	}
    	if ( mhc.equals(MHC_B14)) {
            this.mhc = EnumMhc.B14;
    	}
    	if ( mhc.equals(MHC_B15)) {
            this.mhc = EnumMhc.B15;
    	}
    	if ( mhc.equals(MHC_B19)) {
            this.mhc = EnumMhc.B19;
    	}
    	if ( mhc.equals(MHC_B21)) {
            this.mhc = EnumMhc.B21;
    	}
    	if ( mhc.equals(MHC_B132)) {
            this.mhc = EnumMhc.B132;
    	}
    	if ( mhc.equals(MHC_B142)) {
            this.mhc = EnumMhc.B142;
    	}
    }

    public void setSusceptible(String susceptible) {
    	
    	if ( susceptible.equals(SUSCEPTIBLE_BLANK)) {
            this.susceptible = EnumSusceptible.BLANK;
    	}
    	if ( susceptible.equals(SUSCEPTIBLE_LVV_ABCD)) {
            this.susceptible = EnumSusceptible.LVV_ABCD;
    	}
    	if ( susceptible.equals(SUSCEPTIBLE_LVV_ABDE)) {
            this.susceptible = EnumSusceptible.LVV_ABDE;
    	}
    	if ( susceptible.equals(SUSCEPTIBLE_LLV_AC)) {
            this.susceptible = EnumSusceptible.LLV_AC;
    	}
    	if ( susceptible.equals(SUSCEPTIBLE_LLV_BCD)) {
            this.susceptible = EnumSusceptible.LLV_BCD;
    	}
    	if ( susceptible.equals(SUSCEPTIBLE_MDV)) {
            this.susceptible = EnumSusceptible.MDV;
    	}
    	if ( susceptible.equals(SUSCEPTIBLE_MDV_EIMERIA)) {
            this.susceptible = EnumSusceptible.MDV_EIMERIA;
    	}
    	if ( susceptible.equals(SUSCEPTIBLE_MDV_BCD)) {
            this.susceptible = EnumSusceptible.MDV_BCD;
    	}
    }
    
    public void setResistant(String resistant) {
    	
    	if ( resistant.equals(RESISTANT_BLANK)) {
            this.resistant = EnumResistant.BLANK;
    	}
    	if ( resistant.equals(RESISTANT_LLVTUMOUR)) {
            this.resistant = EnumResistant.LLVTUMOUR;
    	}
    	if ( resistant.equals(RESISTANT_MDV)) {
            this.resistant = EnumResistant.MDV;
    	}
    	if ( resistant.equals(RESISTANT_LLVSUBGROUP)) {
            this.resistant = EnumResistant.LLVSUBGROUP;
    	}
    }
    
    // Check for Required DataTypes ---------------------------------------------------------------


    // Helpers ------------------------------------------------------------------------------------    
    public boolean isMhcBlank() {
    	if ( this.mhc == EnumMhc.BLANK) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isMhcB2() {
    	if ( this.mhc == EnumMhc.B2) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isMhcB4() {
    	if ( this.mhc == EnumMhc.B4) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isMhcB14() {
    	if ( this.mhc == EnumMhc.B14) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isMhcB15() {
    	if ( this.mhc == EnumMhc.B15) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isMhcB19() {
    	if ( this.mhc == EnumMhc.B19) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isMhcB21() {
    	if ( this.mhc == EnumMhc.B21) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isMhcB132() {
    	if ( this.mhc == EnumMhc.B132) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isMhcB142() {
    	if ( this.mhc == EnumMhc.B142) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean isSusceptibleBlank() {
    	if ( this.susceptible == EnumSusceptible.BLANK) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isSusceptibleLVVABCD() {
    	if ( this.susceptible == EnumSusceptible.LVV_ABCD) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isSusceptibleLVVABDE() {
    	if ( this.susceptible == EnumSusceptible.LVV_ABDE) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isSusceptibleLLVAC() {
    	if ( this.susceptible == EnumSusceptible.LLV_AC) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isSusceptibleLLVBCD() {
    	if ( this.susceptible == EnumSusceptible.LLV_BCD) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isSusceptibleMDV() {
    	if ( this.susceptible == EnumSusceptible.MDV) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isSusceptibleMDVEIMERIA() {
    	if ( this.susceptible == EnumSusceptible.MDV_EIMERIA) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isSusceptibleMDVBCD() {
    	if ( this.susceptible == EnumSusceptible.MDV_BCD) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean isResistantBlank() {
    	if ( this.resistant == EnumResistant.BLANK) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isResistantLLVTUMOUR() {
    	if ( this.resistant == EnumResistant.LLVTUMOUR) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isResistantMDV() {
    	if ( this.resistant == EnumResistant.MDV) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isResistantLLVSUBGROUP() {
    	if ( this.resistant == EnumResistant.LLVSUBGROUP) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean isValidMhc() {
    	if ( this.isMhcBlank() ||
    			this.isMhcB132() ||
    			this.isMhcB14() ||
    			this.isMhcB142() ||
    			this.isMhcB15() ||
    			this.isMhcB19() ||
    			this.isMhcB21() ||
    			this.isMhcB4() ) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean isValidSusceptible() {
    	if ( this.isSusceptibleBlank() ||
    			this.isSusceptibleLLVAC() ||
    			this.isSusceptibleLLVBCD() ||
    			this.isSusceptibleLVVABCD() ||
    			this.isSusceptibleLVVABDE() ||
    			this.isSusceptibleMDV() ) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean isValidResistant() {
    	if ( this.isResistantBlank() ||
    			this.isResistantLLVSUBGROUP() ||
    			this.isResistantLLVTUMOUR() ||
    			this.isResistantMDV() ) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }


    /*
     * Is this Line VALID?
     */
    public boolean isThisAValidSearchLine(
    		){

    	if ( this.isValidMhc() &&
    			this.isValidResistant() && 
    			this.isValidSusceptible() ) {
    		
    		return true;
    	}
    	else {
    		
        	return false;
    	}
    }

    
    public List<Line> searchForLines( ServiceLine serviceline ){

        List<Line> searchs = new ArrayList<Line>();

    	if ( !this.isMhcBlank() &&
    			this.isSusceptibleBlank() &&
    			this.isResistantBlank() ) {
    		
            searchs = serviceline.findAllByMhc( this.getMhcAsString() );
    	}
    	else {

        	if ( this.isMhcBlank() &&
        			!this.isSusceptibleBlank() &&
        			this.isResistantBlank() ) {
        		
                searchs = serviceline.findAllBySusceptible( this.getSusceptibleAsString() );
        	}
        	else {
            	if ( this.isMhcBlank() &&
            			this.isSusceptibleBlank() &&
            			!this.isResistantBlank() ) {
            		
                    searchs = serviceline.findAllByResistant( this.getResistantAsString() );
            	}
            	else {

                	if ( !this.isMhcBlank() &&
                			!this.isSusceptibleBlank() &&
                			this.isResistantBlank() ) {
                		
                        searchs = serviceline.findAllByMhcAndSusceptible( this.getMhcAsString(), this.getSusceptibleAsString() );
                	}
                	else {

                    	if ( !this.isMhcBlank() &&
                    			this.isSusceptibleBlank() &&
                    			!this.isResistantBlank() ) {
                    		
                            searchs = serviceline.findAllByMhcAndResistant( this.getMhcAsString(), this.getResistantAsString() );
                    	}
                    	else {
                        	if ( this.isMhcBlank() &&
                        			!this.isSusceptibleBlank() &&
                        			!this.isResistantBlank() ) {
                        		
                                searchs = serviceline.findAllBySusceptibleAndResistant( this.getSusceptibleAsString(), this.getResistantAsString() );
                        	}
                        	else {
                        		
                                searchs = serviceline.findAllByMhcAndSusceptibleAndResistant( this.getMhcAsString(), this.getSusceptibleAsString(), this.getResistantAsString() );
                        	}
                    	}
                	}
            	}
        	}
    	}

    	Collections.sort(searchs, new Line.OrderByLineAsc());
    	
    	return searchs;
    }

    
    
    
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }
}
