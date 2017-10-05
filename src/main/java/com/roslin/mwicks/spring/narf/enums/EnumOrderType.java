package com.roslin.mwicks.spring.narf.enums;


public enum EnumOrderType {
    
	BIRD("Bird"),
	EGG("Egg"),
	EMBRYO("Embryo");

    String enumOrderType;
     
    
    private EnumOrderType(String enumOrderType){
    	
        this.enumOrderType = enumOrderType;
    }
     
    
    public String getEnumOrderType(){
    	
        return enumOrderType;
    }	
    
}
