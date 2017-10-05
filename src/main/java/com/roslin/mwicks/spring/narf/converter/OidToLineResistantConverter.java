package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.LineResistant;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineResistant;


@Component
public class OidToLineResistantConverter implements Converter<Object, LineResistant> {

    @Autowired
    private ServiceLineResistant servicelineresistant;
 
    /**
     * Gets LineResistant by Id
     */
    public LineResistant convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        LineResistant lineresistant = servicelineresistant.findByOid(oid);
        
        return lineresistant;
    }
}
