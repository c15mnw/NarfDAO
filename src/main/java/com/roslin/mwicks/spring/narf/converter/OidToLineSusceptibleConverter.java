package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.LineSusceptible;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineSusceptible;


@Component
public class OidToLineSusceptibleConverter implements Converter<Object, LineSusceptible> {

    @Autowired
    private ServiceLineSusceptible servicelinesusceptible;
 
    /**
     * Gets LineSusceptible by Id
     */
    public LineSusceptible convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        LineSusceptible linesusceptible = servicelinesusceptible.findByOid(oid);
        
        return linesusceptible;
    }
}
