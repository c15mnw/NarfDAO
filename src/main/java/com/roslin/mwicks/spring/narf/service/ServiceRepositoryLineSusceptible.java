package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.LineSusceptible;

import com.roslin.mwicks.spring.narf.repository.RepositoryLineSusceptible;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineSusceptible;

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
public class ServiceRepositoryLineSusceptible implements ServiceLineSusceptible {
    
	@PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryLineSusceptible repositorylinesusceptible;

    
    @Transactional
    public <T extends LineSusceptible> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    private <T extends LineSusceptible> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}

    }

    
    @Transactional(readOnly = true)
    public LineSusceptible findByOid(Long oid) {
    	
        LineSusceptible linesusceptible = repositorylinesusceptible.findOne(oid);
		
        return linesusceptible;
    }
    
     
    @Transactional(readOnly = true)
	public LineSusceptible findByName(String name) {

    	LineSusceptible linesusceptible = repositorylinesusceptible.findByName( name );
        
        return linesusceptible;
	}


	@Transactional(readOnly = true)
	public List<LineSusceptible> findAll() {

		List<LineSusceptible> linesusceptibles = repositorylinesusceptible.findAll();
		
		return linesusceptibles;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryLineSusceptible repositorylinesusceptible) {
    	
        this.repositorylinesusceptible = repositorylinesusceptible;
    }

}
