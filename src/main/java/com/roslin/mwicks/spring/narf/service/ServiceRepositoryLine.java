package com.roslin.mwicks.spring.narf.service;

import com.roslin.mwicks.spring.narf.exception.ExceptionLineNotFound;

import com.roslin.mwicks.spring.narf.model.Line;
import com.roslin.mwicks.spring.narf.model.LineReference;

import com.roslin.mwicks.spring.narf.repository.RepositoryLine;

import com.roslin.mwicks.spring.narf.serviceinterface.ServiceLine;

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
public class ServiceRepositoryLine implements ServiceLine {

    @PersistenceContext
    private EntityManager entityManager;
     
    @Resource
    private RepositoryLine repositoryline;

    
    @Transactional(readOnly = true)
    public Line findByOid(Long oid) {
    	
        Line line = repositoryline.findOne(oid);
		
        return repositoryline.findOne(oid);
    }
    
    
    @Transactional
    public <T extends Line> Collection<T> bulkSave(int intBatchSize, Collection<T> entities) {
    	
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

    
    @Transactional(rollbackFor = ExceptionLineNotFound.class)
    public Line update(Line updated) throws ExceptionLineNotFound {
    	
        Line line = repositoryline.findOne( updated.getOid() );

    	if (line == null) {
        	
            throw new ExceptionLineNotFound("No line found with id: " + updated.getOid());
        }
        
    	line.update(
            	updated.getOid(),
            	updated.getLine(),
            	updated.getBreed(),
            	updated.getOrigin(),
            	updated.getImported(),
            	updated.getLineMhc(),
            	updated.getLineSusceptible(),
            	updated.getLineResistant(),
            	updated.getHistocompatible(),
        		updated.getType(),
        		updated.getLineReferences()
        		);

    	repositoryline.save(line);
    	
    	return line;
    }
    
    

     
    @Transactional(readOnly = true)
	public Line findByLine(String lineIn) {

        Line line = repositoryline.findByLine(lineIn);
        
        return line;
	}


    @Transactional()
	public void save(Line line) {
        
		repositoryline.save(line);
	}


    @Transactional(rollbackFor = ExceptionLineNotFound.class)
	public void delete(Line line) {
        
		repositoryline.delete(line);
	}


    @Transactional(rollbackFor = ExceptionLineNotFound.class)
	public void deleteByOid(Long oid) {

		repositoryline.deleteByOid(oid);
	}


    @Transactional(rollbackFor = ExceptionLineNotFound.class)
	public void deleteByLine(String line) {

		repositoryline.deleteByLine(line);
	}


	@Transactional(readOnly = true)
	public List<Line> findAll() {

		List<Line> lines = repositoryline.findAll();
		
		return lines;
	}
	

	@Transactional(readOnly = true)
	public List<Line> findAllByBreed( String breed ) {

		List<Line> lines = repositoryline.findAllByBreed( breed );
		
		return lines;

	}

	
	@Transactional(readOnly = true)
	public List<Line> findAllByOrigin( String origin ) {

		List<Line> lines = repositoryline.findAllByOrigin( origin );
		
		return lines;

	}

	
	@Transactional(readOnly = true)
	public List<Line> findAllByImported( String imported ) {

		List<Line> lines = repositoryline.findAllByImported( imported );
		
		return lines;

	}

	
	@Transactional(readOnly = true)
	public List<Line> findAllByHistocompatible( String histocompatible ) {

		List<Line> lines = repositoryline.findAllByHistocompatible( histocompatible );
		
		return lines;

	}

	
	@Transactional(readOnly = true)
	public List<Line> findAllByType( String type ) {

		List<Line> lines = repositoryline.findAllByType( type );
		
		return lines;

	}


	@Transactional(readOnly = true)
	public List<Line> findAllByMhcAndSusceptibleAndResistant( String inMhc, String inSusceptible, String inResistant ) {

		List<Line> lines = repositoryline.findAllByMhcAndSusceptibleAndResistant( inMhc, inSusceptible, inResistant );
		
		return lines;
	}


	@Transactional(readOnly = true)
	public List<Line> findAllByMhcAndSusceptible( String inMhc, String inSusceptible ) {

		List<Line> lines = repositoryline.findAllByMhcAndSusceptible( inMhc, inSusceptible );
		
		return lines;
	}


	@Transactional(readOnly = true)
	public List<Line> findAllByMhcAndResistant( String inMhc, String inResistant ) {

		List<Line> lines = repositoryline.findAllByMhcAndResistant( inMhc, inResistant );
		
		return lines;
	}


	@Transactional(readOnly = true)
	public List<Line> findAllBySusceptibleAndResistant( String inSusceptible, String inResistant ) {

		List<Line> lines = repositoryline.findAllBySusceptibleAndResistant( inSusceptible, inResistant );
		
		return lines;
	}


	@Transactional(readOnly = true)
	public List<Line> findAllByMhcOrSusceptibleOrResistant( String inMhc, String inSusceptible, String inResistant ) {

		List<Line> lines = repositoryline.findAllByMhcOrSusceptibleOrResistant( inMhc, inSusceptible, inResistant );
		
		return lines;
	}


	@Transactional(readOnly = true)
	public List<Line> findAllByMhc( String inMhc ) {

		List<Line> lines = repositoryline.findAllByMhc( inMhc );
		
		return lines;
	}


	@Transactional(readOnly = true)
	public List<Line> findAllBySusceptible( String inSusceptible) {

		List<Line> lines = repositoryline.findAllBySusceptible( inSusceptible );
		
		return lines;
	}


	@Transactional(readOnly = true)
	public List<Line> findAllByResistant( String inResistant ) {

		List<Line> lines = repositoryline.findAllByResistant( inResistant );
		
		return lines;
	}


	@Transactional(readOnly = true)
	public List<Line> findAllByLineReference( LineReference inLineReference ) {

		List<Line> lines = repositoryline.findAllByLineReference( inLineReference );
		
		return lines;
	}


	public boolean isLineNameUnique(Long oid, String lineIn) {

		Line line = findByLine(lineIn);
	    
		return ( line == null || ( ( oid != null ) && ( line.getOid() == oid ) ) );
	}


	/**
     * This setter method should be used only by unit tests.
     * @param repositoryLine
     */
    protected void setRepositoryLine(RepositoryLine repositoryline) {
    	
        this.repositoryline = repositoryline;
    }

}
