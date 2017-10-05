package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.LineMhc;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineMhc;


@Component
public class OidToLineMhcConverter implements Converter<Object, LineMhc> {

    @Autowired
    private ServiceLineMhc servicelinemhc;
 
    /**
     * Gets LineMhc by Id
     */
    public LineMhc convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        LineMhc linemhc = servicelinemhc.findByOid(oid);
        
        return linemhc;
    }
}
