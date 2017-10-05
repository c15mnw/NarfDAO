package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionAvianNotFound;

import com.roslin.mwicks.spring.narf.model.Avian;

import com.roslin.mwicks.spring.narf.repository.RepositoryAvian;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceAvian;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the AvianService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryAvian implements ServiceAvian {
    
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryAvian repositoryavian;

    
    @Transactional(readOnly = true)
    public Avian findByOid(Long oid) {
    	
        Avian avian = repositoryavian.findOne(oid);
		
        return repositoryavian.findOne(oid);
    }
    
    
    @Transactional
    public <T extends Avian> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
    	final List<T> savedEntities = new ArrayList<T>(entities.size());
    	int i = 0;

    	for (T t : entities) {
    	    
    		//savedEntities.add(persistOrMerge(t));
    		entityManager.persist(t);

    		i++;
    	    
    		if (i % intBatchSize == 0) {

    			// Flush a batch of inserts and release memory.
    			entityManager.flush();
    			entityManager.clear();
    		}
    	}
    	
    	return savedEntities;
    }

    
    @Transactional(rollbackFor = ExceptionAvianNotFound.class)
    public Avian update(Avian updated) throws ExceptionAvianNotFound {
    	
    	Avian avian = repositoryavian.findOne( updated.getOid() );

    	if (avian == null) {
        	
            throw new ExceptionAvianNotFound("No avian found with id: " + updated.getOid());
        }
        
    	avian.update(
            	updated.getOid(),
        		updated.getName()
        	    );

		repositoryavian.save(avian);

    	return avian;
    }
    
    

     
    @Transactional(readOnly = true)
	public Avian findByName(String name) {

        Avian avian = repositoryavian.findByName(name);
        
        return avian;
	}


    @Transactional()
	public void save(Avian avian) {
        
		repositoryavian.save(avian);
	}


    @Transactional(rollbackFor = ExceptionAvianNotFound.class)
	public void delete(Avian avian) {

        repositoryavian.delete( avian );
	}


    @Transactional(rollbackFor = ExceptionAvianNotFound.class)
	public void deleteByName(String name) {

		repositoryavian.deleteByName(name);
	}


	@Transactional(readOnly = true)
	public List<Avian> findAll() {
		
		List<Avian> avians = repositoryavian.findAll();
		
        return avians;
	}
	


	public boolean isAvianNameUnique(Long oid, String name) {

		Avian avian = findByName(name);
	    
		return ( avian == null || ( ( oid != null ) && ( avian.getOid() == oid ) ) );
	}


	/**
     * This setter method should be used only by unit tests.
     * @param repositoryAvian
     */
    protected void setRepositoryAvian(RepositoryAvian repositoryavian) {
    	
        this.repositoryavian = repositoryavian;
    }
}
