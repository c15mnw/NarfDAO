package com.roslin.mwicks.spring.narf.enums;


public enum EnumOrderStatus {
    
	NEW("New"),
	PENDING_GREENWOOD("Pending - Greenwood"),
	PENDING_BUMSTEAD("Pending - Bumstead"),
	CLOSED("Closed"),
	CANCELLED("Cancelled");

    String enumOrderStatus;
     
    
    private EnumOrderStatus(String enumOrderStatus){
    	
        this.enumOrderStatus = enumOrderStatus;
    }
     
    
    public String getEnumOrderStatus(){
    	
        return enumOrderStatus;
    }	
    
}
