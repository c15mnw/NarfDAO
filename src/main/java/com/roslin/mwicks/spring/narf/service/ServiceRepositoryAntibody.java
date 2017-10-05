package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionAntibodyNotFound;

import com.roslin.mwicks.spring.narf.model.Antibody;
import com.roslin.mwicks.spring.narf.model.AntibodyReference;
import com.roslin.mwicks.spring.narf.repository.RepositoryAntibody;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceAntibody;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This implementation of the AntibodyService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Mike Wicks
 */
@Service
public class ServiceRepositoryAntibody implements ServiceAntibody {
    
    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryAntibody repositoryantibody;

    
    @Transactional(readOnly = true)
    public Antibody findByOid(Long oid) {
    	
        Antibody antibody = repositoryantibody.findOne(oid);
		
        return repositoryantibody.findOne(oid);
    }
    
    
    @Transactional
    public <T extends Antibody> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    
    @Transactional(rollbackFor = ExceptionAntibodyNotFound.class)
    public Antibody update(Antibody updated) throws ExceptionAntibodyNotFound {
    	
    	Antibody antibody = repositoryantibody.findOne( updated.getOid() );

    	if (antibody == null) {
        	
            throw new ExceptionAntibodyNotFound("No antibody found with id: " + updated.getOid());
        }
        
    	antibody.update(
            	updated.getOid(),
        		updated.getName(),
        	    updated.getAntigen(),
        	    updated.getAntigenSearch(),    
        	    updated.getIsotype(),
        	    updated.getSpecies(),
        	    updated.getApplication(),
        	    updated.getSupplier(),
        	    updated.getProductCode(),
        	    updated.getWebsite(),
        	    updated.getAntibodyReferences()
        	    );

		repositoryantibody.save(antibody);

    	return antibody;
    }
    
    

     
    @Transactional(readOnly = true)
	public Antibody findByName(String name) {

        Antibody antibody = repositoryantibody.findByName(name);
        
        return antibody;
	}


    @Transactional()
	public void save(Antibody antibody) {
        
		repositoryantibody.save(antibody);
	}


    @Transactional(rollbackFor = ExceptionAntibodyNotFound.class)
	public void delete(Antibody antibody) {

        repositoryantibody.delete( antibody );
	}


    @Transactional(rollbackFor = ExceptionAntibodyNotFound.class)
	public void deleteByName(String name) {

		repositoryantibody.deleteByName(name);
	}


	@Transactional(readOnly = true)
	public List<Antibody> findAll() {
		
		List<Antibody> antibodys = repositoryantibody.findAll();
		
        return antibodys;
	}
	


	public boolean isAntibodyNameUnique(Long oid, String name) {

		Antibody antibody = findByName(name);
	    
		return ( antibody == null || ( ( oid != null ) && ( antibody.getOid() == oid ) ) );
	}


	/**
     * This setter method should be used only by unit tests.
     * @param repositoryAntibody
     */
    protected void setRepositoryAntibody(RepositoryAntibody repositoryantibody) {
    	
        this.repositoryantibody = repositoryantibody;
    }


	public List<Antibody> findAllByAntibodyReference(AntibodyReference inAntibodyReference) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Antibody> findAllByAntigen(String antigen) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Antibody> findAllByAntigenSearch(String antigenSearch) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Antibody> findAllByIsotype(String isotype) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Antibody> findAllBySpecies(String species) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Antibody> findAllByApplication(String application) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Antibody> findAllBySupplier(String supplier) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Antibody> findAllByProductCode(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Antibody> findAllByWebsite(String website) {
		// TODO Auto-generated method stub
		return null;
	}
}
