package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.model.LineResistant;

import com.roslin.mwicks.spring.narf.repository.RepositoryLineResistant;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLineResistant;

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
public class ServiceRepositoryLineResistant implements ServiceLineResistant {
    
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryLineResistant repositorylineresistant;

    
    @Transactional
    public <T extends LineResistant> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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
    
    private <T extends LineResistant> T persistOrMerge(T t) {

    	if (t.getOid() == 0) {
    		
    		entityManager.persist(t);
    		return t;
    	} 
    	else {
    	
    		return entityManager.merge(t);
    	}
    }

    
    @Transactional(readOnly = true)
    public LineResistant findByOid(Long oid) {
    	
        LineResistant lineresistant = repositorylineresistant.findOne(oid);
		
        return lineresistant;
    }
    
     
    @Transactional(readOnly = true)
	public LineResistant findByName(String name) {

    	LineResistant lineresistant = repositorylineresistant.findByName( name );
        
        return lineresistant;
	}


	@Transactional(readOnly = true)
	public List<LineResistant> findAll() {

		List<LineResistant> lineresistants = repositorylineresistant.findAll();
        
		return lineresistants;
	}

	
	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine( RepositoryLineResistant repositorylineresistant) {
    	
        this.repositorylineresistant = repositorylineresistant;
    }

}
