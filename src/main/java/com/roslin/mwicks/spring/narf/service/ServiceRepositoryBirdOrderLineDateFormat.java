package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.BirdOrderLineDateFormat;

import com.roslin.mwicks.spring.narf.repository.RepositoryBirdOrderLineDateFormat;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceBirdOrderLineDateFormat;

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
public class ServiceRepositoryBirdOrderLineDateFormat implements ServiceBirdOrderLineDateFormat {
    
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryBirdOrderLineDateFormat repositorybirdorderlinedateformat;


    @Transactional
    public <T extends BirdOrderLineDateFormat> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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
    
    private <T extends BirdOrderLineDateFormat> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}

    }

    
    @Transactional(readOnly = true)
    public BirdOrderLineDateFormat findByOid(Long oid) {
    	
        BirdOrderLineDateFormat birdorderlinedateformat = repositorybirdorderlinedateformat.findOne(oid);
		
        return birdorderlinedateformat;
    }
    
     
    @Transactional(readOnly = true)
	public BirdOrderLineDateFormat findByName(String name) {

    	BirdOrderLineDateFormat birdorderlinedateformat = repositorybirdorderlinedateformat.findByName( name );
        
        return birdorderlinedateformat;
	}


	@Transactional(readOnly = true)
	public List<BirdOrderLineDateFormat> findAll() {

		List<BirdOrderLineDateFormat> birdorderlinedateformats = repositorybirdorderlinedateformat.findAll();
		
		return birdorderlinedateformats;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryBirdOrderLineDateFormat repositorybirdorderlinedateformat) {
    	
        this.repositorybirdorderlinedateformat = repositorybirdorderlinedateformat;
    }

}
