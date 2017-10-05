package com.roslin.mwicks.spring.narf.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.OrderStatus;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceOrderStatus;


@Component
public class OidToOrderStatusConverter implements Converter<Object, Set<OrderStatus>> {

    @Autowired
    private ServiceOrderStatus serviceorderstatus;
 
    /**
     * Gets OrderStatusSex by Id
     */
    public Set<OrderStatus> convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        OrderStatus orderstatus = serviceorderstatus.findByOid(oid);
        
        Set<OrderStatus> OrderStatuss = new HashSet<OrderStatus>();
        
        OrderStatuss.add(orderstatus);
        
        return OrderStatuss;
    }
}
