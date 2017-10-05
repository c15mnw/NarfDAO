package com.roslin.mwicks.spring.narf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.StrainReference;

/**
 * Specifies methods used to obtain and modify Strain related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryStrainReference extends JpaRepository<StrainReference, Long> {

	public StrainReference findByOid( Long oid );
	public StrainReference findByReference( String reference );

	public List<StrainReference> findAllByReference( String reference );
	public List<StrainReference> findAllByUrl( String url );

	public void deleteByOid( Long oid );
	public void deleteByReference( String reference );

}
