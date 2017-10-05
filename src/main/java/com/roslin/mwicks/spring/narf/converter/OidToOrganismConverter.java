package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.Organism;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceOrganism;


@Component
public class OidToOrganismConverter implements Converter<Object, Organism> {

    @Autowired
    private ServiceOrganism serviceorganism;
 
    /**
     * Gets Organism by Id
     */
    public Organism convert(Object element){
    	
    	System.out.println("element.toString() : " + element.toString());
    	
        Long oid = Long.parseLong( (String) element );
        
        Organism organism = serviceorganism.findByOid(oid);
        
        return organism;
    }
}
