package com.roslin.mwicks.spring.narf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.StrainUse;

/**
 * Specifies methods used to obtain and modify Strain related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryStrainUse extends JpaRepository<StrainUse, Long> {

	public StrainUse findByOid( Long oid );
	public StrainUse findByUse( String use );
	public StrainUse findByProtocol( String protocol );

	public List<StrainUse> findAllByUse( String use );
	public List<StrainUse> findAllByProtocol( String protocol );

	public void deleteByOid( Long oid );
	public void deleteByUse( String use );
	public void deleteByProtocol( String protocol );

}
