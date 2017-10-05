package com.roslin.mwicks.spring.narf.enums;


public enum EnumOrderCollection {
    
	UNKNOWN("Unknown"),
	COURIER_NARF("NARF to Courier"),
	PICKUP_IN_PERSON("Customer to Pickup in Person"),
	COURIER_CUSTOMER("Customer to Courier");

    String enumOrderCollection;
     
    
    private EnumOrderCollection(String enumOrderCollection){
    	
        this.enumOrderCollection = enumOrderCollection;
    }
     
    
    public String getEnumOrderCollection(){
    	
        return enumOrderCollection;
    }	
    
}
