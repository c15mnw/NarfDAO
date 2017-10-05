package com.roslin.mwicks.spring.narf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roslin.mwicks.spring.narf.model.Antibody;
import com.roslin.mwicks.spring.narf.model.AntibodyReference;

/**
 * Specifies methods used to obtain and modify Antibody related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryAntibody extends JpaRepository<Antibody, Long> {

	@Query("Select p from Antibody p " +
		   "inner join p.antibodyReferences reference " +
	       "where reference = :inAntibodyReference " )
	public List<Antibody> findAllByAntibodyReference(
			@Param("inAntibodyReference") AntibodyReference inAntibodyReference ); 

	public Antibody findByOid( Long oid );
	public Antibody findByName(String name);

	public List<Antibody> findAllByAntigen(String antigen);
	public List<Antibody> findAllByAntigenSearch(String antigenSearch);
	public List<Antibody> findAllByIsotype(String isotype);
	public List<Antibody> findAllBySpecies(String species);
	public List<Antibody> findAllByApplication(String application);
	public List<Antibody> findAllBySupplier(String supplier);
	public List<Antibody> findAllByProductCode(String productCode);
	public List<Antibody> findAllByWebsite(String website);
    
	public void deleteByOid( Long oid );
	public void deleteByName( String name );
	
}
