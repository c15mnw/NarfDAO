package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.StrainReference;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceStrainReference;


@Component
public class OidToStrainReferenceConverter implements Converter<String, StrainReference> {

    @Autowired
    private ServiceStrainReference servicestrainreference;
 
    /**
     * Gets LineReference by Id
     */
    public StrainReference convert(String element){
    	
        Long oid = Long.parseLong( element );
        //Long oid = Long.parseLong( (String) element );
        
        StrainReference strainreference = servicestrainreference.findByOid(oid);
        
        return strainreference;
    }
}
