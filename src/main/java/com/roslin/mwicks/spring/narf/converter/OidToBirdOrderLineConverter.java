package com.roslin.mwicks.spring.narf.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.BirdOrderLine;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceBirdOrderLine;


@Component
public class OidToBirdOrderLineConverter implements Converter<Object, Set<BirdOrderLine>> {

    @Autowired
    private ServiceBirdOrderLine servicebirdorderline;
 
    /**
     * Gets BirdOrderLineSex by Id
     */
    public Set<BirdOrderLine> convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        BirdOrderLine birdorderline = servicebirdorderline.findByOid(oid);
        
        Set<BirdOrderLine> BirdOrderLines = new HashSet<BirdOrderLine>();
        
        BirdOrderLines.add(birdorderline);
        
        return BirdOrderLines;
    }
}
