package com.roslin.mwicks.spring.narf.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.roslin.mwicks.spring.narf.model.AntibodyReference;

/**
 * Specifies methods used to obtain and modify Antibody related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryAntibodyReference extends JpaRepository<AntibodyReference, Long> {

	public AntibodyReference findOne( @Param("oid") Long oid )throws DataAccessException;

	public AntibodyReference findByOid( Long oid );
	public AntibodyReference findByReference( String reference );

	public List<AntibodyReference> findAllByReference( String reference );
	public List<AntibodyReference> findAllByUrl( String url );

	public void deleteByOid( Long oid );
	public void deleteByReference( String reference );

}
