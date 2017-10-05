package com.roslin.mwicks.spring.narf.enums;


public enum EnumDateFormat {
    
	DAY("Days"),
	MONTH("Months"),
	YEAR("Years");

    String enumEnumDateFormat;
     
    
    private EnumDateFormat(String enumEnumDateFormat){
    	
        this.enumEnumDateFormat = enumEnumDateFormat;
    }
     
    
    public String getEnumDateFormat(){
    	
        return enumEnumDateFormat;
    }	
    
}
