package com.roslin.mwicks.spring.narf.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.OrderCollection;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceOrderCollection;


@Component
public class OidToOrderCollectionConverter implements Converter<Object, Set<OrderCollection>> {

    @Autowired
    private ServiceOrderCollection serviceordercollection;
 
    /**
     * Gets OrderCollectionSex by Id
     */
    public Set<OrderCollection> convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        OrderCollection ordercollection = serviceordercollection.findByOid(oid);
        
        Set<OrderCollection> OrderCollections = new HashSet<OrderCollection>();
        
        OrderCollections.add(ordercollection);
        
        return OrderCollections;
    }
}
