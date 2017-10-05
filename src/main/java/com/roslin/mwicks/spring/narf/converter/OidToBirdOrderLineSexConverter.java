package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.BirdOrderLineSex;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceBirdOrderLineSex;


@Component
public class OidToBirdOrderLineSexConverter implements Converter<Object, BirdOrderLineSex> {

    @Autowired
    private ServiceBirdOrderLineSex servicebirdorderlinesex;
 
    /**
     * Gets BirdOrderLineSex by Id
     */
    public BirdOrderLineSex convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        BirdOrderLineSex birdorderlinesex = servicebirdorderlinesex.findByOid(oid);
        
        return birdorderlinesex;
    }
}
