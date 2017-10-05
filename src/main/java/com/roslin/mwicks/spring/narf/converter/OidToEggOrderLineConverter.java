package com.roslin.mwicks.spring.narf.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.EggOrderLine;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceEggOrderLine;


@Component
public class OidToEggOrderLineConverter implements Converter<Object, Set<EggOrderLine>> {

    @Autowired
    private ServiceEggOrderLine serviceeggorderline;
 
    /**
     * Gets EggOrderLineSex by Id
     */
    public Set<EggOrderLine> convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        EggOrderLine eggorderline = serviceeggorderline.findByOid(oid);
        
        Set<EggOrderLine> EggOrderLines = new HashSet<EggOrderLine>();
        
        EggOrderLines.add(eggorderline);
        
        return EggOrderLines;
    }
}
