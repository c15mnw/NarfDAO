package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.BirdOrderLineDateFormat;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceBirdOrderLineDateFormat;


@Component
public class OidToBirdOrderLineDateFormatConverter implements Converter<Object, BirdOrderLineDateFormat> {

    @Autowired
    private ServiceBirdOrderLineDateFormat servicebirdorderlinedateformat;
 
    /**
     * Gets BirdOrderLineDateFormat by Id
     */
    public BirdOrderLineDateFormat convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        BirdOrderLineDateFormat birdorderlinedateformat = servicebirdorderlinedateformat.findByOid(oid);
        
        return birdorderlinedateformat;
    }
}
