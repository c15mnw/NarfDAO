package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.StrainUse;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceStrainUse;


@Component
public class OidToStrainUseConverter implements Converter<String, StrainUse> {

    @Autowired
    private ServiceStrainUse servicestrainuse;
 
    /**
     * Gets LineReference by Id
     */
    public StrainUse convert(String element){
    	
        Long oid = Long.parseLong( element );
        //Long oid = Long.parseLong( (String) element );
        
        StrainUse strainuse = servicestrainuse.findByOid(oid);
        
        return strainuse;
    }
}
