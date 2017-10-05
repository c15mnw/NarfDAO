package com.roslin.mwicks.spring.narf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roslin.mwicks.spring.narf.model.Line;
import com.roslin.mwicks.spring.narf.model.LineReference;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryLine extends JpaRepository<Line, Long> {

	@Query("Select p from Line p " +
		   "inner join p.lineReferences reference " +
	       "where reference = :inLineReference " )
	public List<Line> findAllByLineReference(
			@Param("inLineReference") LineReference inLineReference ); 

	@Query("Select p from Line p " +
	       "where p.lineMhc.name = :inMhc " +
	       "and p.lineSusceptible.name = :inSusceptible "+
	       "and p.lineResistant.name = :inResistant " )
	public List<Line> findAllByMhcAndSusceptibleAndResistant(
			@Param("inMhc") String inMhc, 
			@Param("inSusceptible") String inSusceptible, 
			@Param("inResistant") String inResistant );

	@Query("Select p from Line p " +
	       "where p.lineMhc.name = :inMhc " +
	       "or p.lineSusceptible.name = :inSusceptible "+
	       "or p.lineResistant.name = :inResistant " )
	public List<Line> findAllByMhcOrSusceptibleOrResistant(
			@Param("inMhc") String inMhc, 
			@Param("inSusceptible") String inSusceptible, 
			@Param("inResistant") String inResistant );

	@Query("Select p from Line p " +
	       "where p.lineMhc.name = :inMhc " )
	public List<Line> findAllByMhc(
			@Param("inMhc") String inMhc );

	@Query("Select p from Line p " +
	       "where p.lineSusceptible.name = :inSusceptible " )
	public List<Line> findAllBySusceptible(
			@Param("inSusceptible") String inSusceptible );

	@Query("Select p from Line p " +
	       "where p.lineResistant.name = :inResistant " )
	public List<Line> findAllByResistant(
			@Param("inResistant") String inResistant );

	@Query("Select p from Line p " +
	       "where p.lineMhc.name = :inMhc " +
	       "and p.lineSusceptible.name = :inSusceptible ")
	public List<Line> findAllByMhcAndSusceptible( 
			@Param("inMhc") String inMhc, 
			@Param("inSusceptible") String inSusceptible );

	@Query("Select p from Line p " +
	       "where p.lineMhc.name = :inMhc " +
	       "and p.lineResistant.name = :inResistant " )
	public List<Line> findAllByMhcAndResistant( 
			@Param("inMhc") String inMhc, 
			@Param("inResistant") String inResistant );
	
	@Query("Select p from Line p " +
	       "where p.lineSusceptible.name = :inSusceptible "+
	       "and p.lineResistant.name = :inResistant " )
	public List<Line> findAllBySusceptibleAndResistant( 
			@Param("inSusceptible") String inSusceptible, 
			@Param("inResistant") String inResistant );

	public Line findByOid( Long oid );
	public Line findByLine( String line );

	public List<Line> findAllByLine( String line );
	public List<Line> findAllByBreed( String breed );
	public List<Line> findAllByOrigin( String origin );
	public List<Line> findAllByImported( String imported );
	public List<Line> findAllByHistocompatible( String histocompatible );
	public List<Line> findAllByType( String type );

	public void deleteByOid( Long oid );
	public void deleteByLine( String line );
	
}
