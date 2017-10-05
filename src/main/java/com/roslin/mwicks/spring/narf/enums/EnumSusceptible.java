package com.roslin.mwicks.spring.narf.enums;


public enum EnumSusceptible {
    
	BLANK(""),
	LVV_ABCD("LLV subgroups A, B, C, D"),
	LVV_ABDE("LLV subgroups A, B, D, E"),
	LLV_AC("LLV subgroups A, C; segregating for B, D, E. Moderately susceptible to MDV"),
	LLV_BCD("LLV subgroups B, C, D"),
	MDV("MDV"),
	MDV_EIMERIA("MDV, embryos susceptible to Eimeria sp."),
	MDV_BCD("LLV subgroups B, C, D (not A, E) and to Eimeria sp.");

    String enumSusceptible;
     
    
    private EnumSusceptible(String enumSusceptible){
    	
        this.enumSusceptible = enumSusceptible;
    }
     
    
    public String getEnumSusceptible(){
    	
        return enumSusceptible;
    }	
    
}
