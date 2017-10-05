package com.roslin.mwicks.spring.narf.enums;


public enum EnumFertilised {
    
	FERTILISED("Fertilised"),
	UNFERTILISED("Unfertilised");

    String enumFertilised;
     
    
    private EnumFertilised(String enumFertilised){
    	
        this.enumFertilised = enumFertilised;
    }
     
    
    public String getEnumFertilised(){
    	
        return enumFertilised;
    }	
    
}
