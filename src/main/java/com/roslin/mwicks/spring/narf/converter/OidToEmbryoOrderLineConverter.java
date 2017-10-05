package com.roslin.mwicks.spring.narf.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.EmbryoOrderLine;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceEmbryoOrderLine;


@Component
public class OidToEmbryoOrderLineConverter implements Converter<Object, Set<EmbryoOrderLine>> {

    @Autowired
    private ServiceEmbryoOrderLine serviceembryoorderline;
 
    /**
     * Gets EmbryoOrderLineSex by Id
     */
    public Set<EmbryoOrderLine> convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        EmbryoOrderLine embryoorderline = serviceembryoorderline.findByOid(oid);
        
        Set<EmbryoOrderLine> EmbryoOrderLines = new HashSet<EmbryoOrderLine>();
        
        EmbryoOrderLines.add(embryoorderline);
        
        return EmbryoOrderLines;
    }
}
