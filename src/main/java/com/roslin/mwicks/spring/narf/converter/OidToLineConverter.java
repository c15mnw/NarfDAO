package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.Line;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLine;


@Component
public class OidToLineConverter implements Converter<Object, Line> {

    @Autowired
    private ServiceLine serviceline;
 
    /**
     * Gets Line by Id
     */
    public Line convert(Object element){
    	
    	System.out.println("element.toString() : " + element.toString());
    	
        Long oid = Long.parseLong( (String) element );
        
        Line line = serviceline.findByOid(oid);
        
        return line;
    }
}
