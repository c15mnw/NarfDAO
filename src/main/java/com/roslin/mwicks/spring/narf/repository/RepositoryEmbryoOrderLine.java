package com.roslin.mwicks.spring.narf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roslin.mwicks.spring.narf.model.EmbryoOrderLine;

/**
 * Specifies methods used to obtain and modify EmbryoOrderLine related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryEmbryoOrderLine extends JpaRepository<EmbryoOrderLine, Long> {

	public EmbryoOrderLine findByOid( Long oid );

	public void deleteByOid( Long oid );

}
