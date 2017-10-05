package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.EggOrderLineFertilised;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceEggOrderLineFertilised;


@Component
public class OidToEggOrderLineFertilisedConverter implements Converter<Object, EggOrderLineFertilised> {

    @Autowired
    private ServiceEggOrderLineFertilised serviceeggorderlinefertilised;
 
    /**
     * Gets EggOrderLineFertilised by Id
     */
    public EggOrderLineFertilised convert(Object element){
    	
        Long oid = Long.parseLong( (String) element );
        
        EggOrderLineFertilised eggorderlinefertilised = serviceeggorderlinefertilised.findByOid(oid);
        
        return eggorderlinefertilised;
    }
}
