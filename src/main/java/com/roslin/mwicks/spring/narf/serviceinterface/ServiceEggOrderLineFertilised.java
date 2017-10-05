package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.model.EggOrderLineFertilised;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceEggOrderLineFertilised {
	
	public <T extends EggOrderLineFertilised> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);

	public EggOrderLineFertilised findByOid( Long oid );
    public EggOrderLineFertilised findByName( String name );

    public List<EggOrderLineFertilised> findAll(); 

}
