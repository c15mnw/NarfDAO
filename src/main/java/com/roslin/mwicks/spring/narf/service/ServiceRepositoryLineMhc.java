package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.LineMhc;

import com.roslin.mwicks.spring.narf.repository.RepositoryLineMhc;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineMhc;

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
public class ServiceRepositoryLineMhc implements ServiceLineMhc {
  
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryLineMhc repositorylinemhc;


    @Transactional
    public <T extends LineMhc> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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
    
    private <T extends LineMhc> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}

    }

    
    @Transactional(readOnly = true)
    public LineMhc findByOid(Long oid) {
    	
        LineMhc linemhc = repositorylinemhc.findOne(oid);
		
        return linemhc;
    }
    
     
    @Transactional(readOnly = true)
	public LineMhc findByName(String name) {

    	LineMhc linemhc = repositorylinemhc.findByName( name );
        
        return linemhc;
	}


	@Transactional(readOnly = true)
	public List<LineMhc> findAll() {

		List<LineMhc> linemhcs = repositorylinemhc.findAll();
		
		return linemhcs;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryLineMhc repositorylinemhc) {
    	
        this.repositorylinemhc = repositorylinemhc;
    }

}
