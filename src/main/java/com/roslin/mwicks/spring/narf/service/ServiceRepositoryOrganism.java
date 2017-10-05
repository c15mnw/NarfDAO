package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionOrganismNotFound;

import com.roslin.mwicks.spring.narf.model.Organism;

import com.roslin.mwicks.spring.narf.repository.RepositoryOrganism;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceOrganism;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the OrganismService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryOrganism implements ServiceOrganism {
    
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryOrganism repositoryorganism;

    
    @Transactional(readOnly = true)
    public Organism findByOid(Long oid) {
    	
        Organism organism = repositoryorganism.findOne(oid);
		
        return repositoryorganism.findOne(oid);
    }
    
    
    @Transactional
    public <T extends Organism> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    
    @Transactional(rollbackFor = ExceptionOrganismNotFound.class)
    public Organism update(Organism updated) throws ExceptionOrganismNotFound {
    	
    	Organism organism = repositoryorganism.findOne( updated.getOid() );

    	if (organism == null) {
        	
            throw new ExceptionOrganismNotFound("No organism found with id: " + updated.getOid());
        }
        
    	organism.update(
            	updated.getOid(),
        		updated.getName(),
        	    updated.getLines(),
        	    updated.getStrains(),
        	    updated.getAvians()
        	    );

		repositoryorganism.save(organism);

    	return organism;
    }
    
    

     
    @Transactional(readOnly = true)
	public Organism findByName(String name) {

        Organism organism = repositoryorganism.findByName(name);
        
        return organism;
	}


    @Transactional()
	public void save(Organism organism) {
        
		repositoryorganism.save(organism);
	}


    @Transactional(rollbackFor = ExceptionOrganismNotFound.class)
	public void delete(Organism organism) {

        repositoryorganism.delete( organism );
	}


    @Transactional(rollbackFor = ExceptionOrganismNotFound.class)
	public void deleteByName(String name) {

		repositoryorganism.deleteByName(name);
	}


	@Transactional(readOnly = true)
	public List<Organism> findAll() {
		
		List<Organism> organisms = repositoryorganism.findAll();
		
        return organisms;
	}
	


	public boolean isOrganismNameUnique(Long oid, String name) {

		Organism organism = findByName(name);
	    
		return ( organism == null || ( ( oid != null ) && ( organism.getOid() == oid ) ) );
	}


	/**
     * This setter method should be used only by unit tests.
     * @param repositoryOrganism
     */
    protected void setRepositoryOrganism(RepositoryOrganism repositoryorganism) {
    	
        this.repositoryorganism = repositoryorganism;
    }
}
