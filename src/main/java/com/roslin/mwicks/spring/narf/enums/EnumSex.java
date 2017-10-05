package com.roslin.mwicks.spring.narf.enums;


public enum EnumSex {
    
	MALE("Male"),
	FEMALE("Female");

    String enumSex;
     
    
    private EnumSex(String enumSex){
    	
        this.enumSex = enumSex;
    }
     
    
    public String getEnumSex(){
    	
        return enumSex;
    }	
    
}
