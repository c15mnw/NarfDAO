package com.roslin.mwicks.spring.narf.serviceinterface;

import java.util.Collection;
import java.util.List;

import com.roslin.mwicks.spring.narf.exception.ExceptionLineNotFound;

import com.roslin.mwicks.spring.narf.model.Line;
import com.roslin.mwicks.spring.narf.model.LineReference;


/**
 * Declares methods used to obtain and modify Line information.
 * @author Mike Wicks
 */
public interface ServiceLine {

	public List<Line> findAllByLineReference( LineReference inLineReference );

	public List<Line> findAllByMhcAndSusceptibleAndResistant( String inMhc, String inSusceptible, String inResistant );

	public List<Line> findAllByMhcOrSusceptibleOrResistant( String inMhc, String inSusceptible, String inResistant );

	public List<Line> findAllByMhc( String inMhc );
	public List<Line> findAllBySusceptible( String inSusceptible );
	public List<Line> findAllByResistant( String inResistant );

	public List<Line> findAllByMhcAndSusceptible( String inMhc, String inSusceptible );
	public List<Line> findAllByMhcAndResistant( String inMhc, String inResistant );
	public List<Line> findAllBySusceptibleAndResistant( String inSusceptible, String inResistant );

	public <T extends Line> Collection<T> bulkSave(int intBatchSize, Collection<T> entities);
	
    public Line findByOid(Long oid);
    public Line findByLine(String line);

    public List<Line> findAll(); 

	public List<Line> findAllByBreed( String breed );
	public List<Line> findAllByOrigin( String origin );
	public List<Line> findAllByImported( String imported );
	public List<Line> findAllByHistocompatible( String histocompatible );
	public List<Line> findAllByType( String type );

    public void save(Line line);

    public Line update(Line line) throws ExceptionLineNotFound;
    
    public void delete(Line line) throws ExceptionLineNotFound;

    public void deleteByOid(Long oid) throws ExceptionLineNotFound;
    public void deleteByLine(String line) throws ExceptionLineNotFound;
    
    boolean isLineNameUnique(Long oid, String name);
}
