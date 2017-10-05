package com.roslin.mwicks.spring.narf.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.OrderType;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceOrderType;


@Component
public class OidToOrderTypeConverter implements Converter<Object, Set<OrderType>> {

    @Autowired
    private ServiceOrderType serviceordertype;
 
    /**
     * Gets OrderTypeSex by Id
     */
    public Set<OrderType> convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        OrderType ordertype = serviceordertype.findByOid(oid);
        
        Set<OrderType> OrderTypes = new HashSet<OrderType>();
        
        OrderTypes.add(ordertype);
        
        return OrderTypes;
    }
}
