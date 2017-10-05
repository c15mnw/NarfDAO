package com.roslin.mwicks.spring.narf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.LineReference;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryLineReference extends JpaRepository<LineReference, Long> {

	public LineReference findByOid( Long oid );
	public LineReference findByReference( String reference );

	public List<LineReference> findAllByReference( String reference );
	public List<LineReference> findAllByUrl( String url );

	public void deleteByOid( Long oid );
	public void deleteByReference( String reference );

}
