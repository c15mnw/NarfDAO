package com.roslin.mwicks.spring.narf.enums;


public enum EnumResistant {
    
	BLANK(""),
	LLVTUMOUR("MDV, LLV tumour development"),
	MDV("MDV"),
	LLVSUBGROUP("LLV subgroups B and D (mostly), segregating for A and E. Hatched birds resistant to Eimeria sp.");

    String enumEnumResistant;

    
    private EnumResistant(String enumEnumResistant){
    
    	this.enumEnumResistant = enumEnumResistant;
    }

    
    public String getEnumResistant(){
    	
        return enumEnumResistant;
    }	
    
}
