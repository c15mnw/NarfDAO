package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.EggOrderLineFertilised;

import com.roslin.mwicks.spring.narf.repository.RepositoryEggOrderLineFertilised;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceEggOrderLineFertilised;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the LineService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryEggOrderLineFertilised implements ServiceEggOrderLineFertilised {

    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryEggOrderLineFertilised repositoryeggorderlinefertilised;


    @Transactional
    public <T extends EggOrderLineFertilised> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
    	final List<T> savedEntities = new ArrayList<T>(entities.size());
    	int i = 0;

    	for (T t : entities) {
    	    
    		savedEntities.add(persistOrMerge(t));
    		//entityManager.persist(t);

    		i++;
    	    
    		if (i % intBatchSize == 0) {

    			// Flush a batch of inserts and release memory.
    			entityManager.flush();
    			entityManager.clear();
    		}
    	}
    	
    	return savedEntities;
    }
    
    private <T extends EggOrderLineFertilised> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}

    }

    
    @Transactional(readOnly = true)
    public EggOrderLineFertilised findByOid(Long oid) {
    	
        EggOrderLineFertilised eggorderlinefertilised = repositoryeggorderlinefertilised.findOne(oid);
		
        return eggorderlinefertilised;
    }
    
     
    @Transactional(readOnly = true)
	public EggOrderLineFertilised findByName(String name) {

    	EggOrderLineFertilised eggorderlinefertilised = repositoryeggorderlinefertilised.findByName( name );
        
        return eggorderlinefertilised;
	}


	@Transactional(readOnly = true)
	public List<EggOrderLineFertilised> findAll() {

		List<EggOrderLineFertilised> eggorderlinefertiliseds = repositoryeggorderlinefertilised.findAll();
		
		return eggorderlinefertiliseds;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryEggOrderLineFertilised repositoryeggorderlinefertilised) {
    	
        this.repositoryeggorderlinefertilised = repositoryeggorderlinefertilised;
    }

}
