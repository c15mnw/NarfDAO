package com.roslin.mwicks.spring.narf.format;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringStyle;


public class CustomDateToStringStyle extends ToStringStyle {
	
    private static final long serialVersionUID = 1L;
    
    protected void appendDetail(StringBuffer buffer, String fieldName, Object value)
    {
         if (value instanceof Date) {
        	 
             value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
         }
         
         buffer.append(value);
     }
}