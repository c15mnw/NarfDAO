package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.EmbryoOrderLineIncubation;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceEmbryoOrderLineIncubation;


@Component
public class OidToEmbryoOrderLineIncubationConverter implements Converter<Object, EmbryoOrderLineIncubation> {

    @Autowired
    private ServiceEmbryoOrderLineIncubation serviceembryoorderlineincubation;
 
    /**
     * Gets EmbryoOrderLineIncubation by Id
     */
    public EmbryoOrderLineIncubation convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        EmbryoOrderLineIncubation embryoorderlineincubation = serviceembryoorderlineincubation.findByOid(oid);
        
        return embryoorderlineincubation;
    }
}
