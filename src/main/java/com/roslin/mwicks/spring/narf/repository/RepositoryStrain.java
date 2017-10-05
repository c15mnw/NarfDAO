package com.roslin.mwicks.spring.narf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roslin.mwicks.spring.narf.model.Strain;
import com.roslin.mwicks.spring.narf.model.StrainReference;
import com.roslin.mwicks.spring.narf.model.StrainUse;

/**
 * Specifies methods used to obtain and modify Strain related information
 * which is stored in the database.
 * @author Mike Wicks
 */
public interface RepositoryStrain extends JpaRepository<Strain, Long> {

	@Query("Select p from Strain p " +
	    "inner join p.strainReferences reference " +
		"where reference = :inStrainReference " )
	public List<Strain> findAllByStrainReference(
		@Param("inStrainReference") StrainReference inStrainReference ); 

	@Query("Select p from Strain p " +
	    "inner join p.strainUses use " +
		"where use = :inStrainUse " )
	public List<Strain> findAllByStrainUse(
		@Param("inStrainUse") StrainUse inStrainUse ); 

	@Query("Select p from Strain p " +
		    "inner join p.strainUses use " +
			"where p.strain = :inStrain " +
			"and use = :inStrainUse " )
		public List<Strain> findAllByStrainAndStrainUse(
			@Param("inStrain") String inStrain ,
			@Param("inStrainUse") StrainUse inStrainUse );

	public Strain findByOid( Long oid );
	public Strain findByStrain( String strain );

	public List<Strain> findAllByStrain( String strain );
	public List<Strain> findAllByStrainLong( String strainLong );
	public List<Strain> findAllByProtein( String protein );
	public List<Strain> findAllBySpectra( String spectra );
	public List<Strain> findAllByPattern( String pattern );
	public List<Strain> findAllByAvailability( String availability );
	public List<Strain> findAllByDescription( String description );
	public List<Strain> findAllByContact( String contact );
	public List<Strain> findAllByPrice( String price );

	public void deleteByOid( Long oid );
	public void deleteByStrain( String strain );
	
}
