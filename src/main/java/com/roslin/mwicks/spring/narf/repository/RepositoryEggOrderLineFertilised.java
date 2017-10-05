package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.EggOrderLineFertilised;

/**
 * Specifies methods used to obtain and modify Line related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryEggOrderLineFertilised extends JpaRepository<EggOrderLineFertilised, Long> {

	public EggOrderLineFertilised findByOid( Long oid );
	public EggOrderLineFertilised findByName( String name );

}
