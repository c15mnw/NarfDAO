package com.roslin.mwicks.spring.narf.converter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;

import com.roslin.mwicks.spring.narf.model.AntibodyReference;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceAntibodyReference;


@Component
public class OidToAntibodyReferenceConverter implements Converter<String, AntibodyReference> {

    @Autowired
    private ServiceAntibodyReference serviceantibodyreference;
 
    /**
     * Gets AntibodyReference by Id
     */
    public AntibodyReference convert(String element){
    	
        Long oid = Long.parseLong( element );
        //Long oid = Long.parseLong( (String) element );
        
        AntibodyReference antibodyreference = serviceantibodyreference.findByOid(oid);
        
        return antibodyreference;
    }
}
