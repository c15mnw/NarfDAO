package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.LineReference;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineReference;


@Component
public class OidToLineReferenceConverter implements Converter<String, LineReference> {

    @Autowired
    private ServiceLineReference servicelinereference;
 
    /**
     * Gets LineReference by Id
     */
    public LineReference convert(String element){
    	
        Long oid = Long.parseLong( element );
        //Long oid = Long.parseLong( (String) element );
        
        LineReference linereference = servicelinereference.findByOid(oid);
        
        return linereference;
    }
}
