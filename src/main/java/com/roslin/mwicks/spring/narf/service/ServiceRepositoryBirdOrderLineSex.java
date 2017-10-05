package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.BirdOrderLineSex;

import com.roslin.mwicks.spring.narf.repository.RepositoryBirdOrderLineSex;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceBirdOrderLineSex;

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
public class ServiceRepositoryBirdOrderLineSex implements ServiceBirdOrderLineSex {

	@PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryBirdOrderLineSex repositorybirdorderlinesex;


    @Transactional
    public <T extends BirdOrderLineSex> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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
    
    private <T extends BirdOrderLineSex> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}

    }

    
    @Transactional(readOnly = true)
    public BirdOrderLineSex findByOid(Long oid) {
    	
        BirdOrderLineSex birdorderlinesex = repositorybirdorderlinesex.findOne(oid);
		
        return birdorderlinesex;
    }
    
     
    @Transactional(readOnly = true)
	public BirdOrderLineSex findByName(String name) {

    	BirdOrderLineSex birdorderlinesex = repositorybirdorderlinesex.findByName( name );
        
        return birdorderlinesex;
	}


	@Transactional(readOnly = true)
	public List<BirdOrderLineSex> findAll() {

		List<BirdOrderLineSex> birdorderlinesexs = repositorybirdorderlinesex.findAll();
		
		return birdorderlinesexs;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryBirdOrderLineSex repositorybirdorderlinesex) {
    	
        this.repositorybirdorderlinesex = repositorybirdorderlinesex;
    }

}
