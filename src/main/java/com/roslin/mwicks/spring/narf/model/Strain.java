package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;

/**
 * An entity class which contains the information of a single Strain Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_strain")
public class Strain implements Serializable, Comparable<Strain>{
    
    // Constants ----------------------------------------------------------------------------------


	// Properties ---------------------------------------------------------------------------------

    // ncl_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ncs_oid", nullable = true)
    private Long oid;
    
    // ncl_strain varchar(255)
    @Column(name = "ncs_strain", nullable = false)
    private String strain;

    // ncl_strain varchar(255)
    @Column(name = "ncs_strain_long", nullable = false)
    private String strainLong;

    // ncl_strain varchar(255)
    @Column(name = "ncs_protein", nullable = false)
    private String protein;

    // ncl_strain varchar(255)
    @Column(name = "ncs_spectra", nullable = false)
    private String spectra;

    // ncl_strain varchar(255)
    @Column(name = "ncs_pattern", nullable = false)
    private String pattern;

    // ncl_strain varchar(255)
    @Column(name = "ncs_availability", nullable = false)
    private String availability;

    // ncl_strain varchar(255)
    @Column(name = "ncs_description", nullable = false)
    private String description;

    // ncl_strain varchar(255)
    @Column(name = "ncs_contact", nullable = false)
    private String contact;

    // ncl_strain varchar(255)
    @Column(name = "ncs_price", nullable = false)
    private String price;
    
    @Column(name = "ncs_creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "ncs_modification_time", nullable = true)
    private Date modificationTime;
    
    @Version
    @Column(name = "ncs_version", nullable = false)
    private long version;
    
    // @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_strain_strain_reference", 
               joinColumns = { @JoinColumn(name = "ncs_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "ncsr_oid") })
    private Set<StrainReference> strainReferences = new HashSet<StrainReference>();
    
    // @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_strain_strain_use", 
               joinColumns = { @JoinColumn(name = "ncs_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "ncsu_oid") })
    private Set<StrainUse> strainUses = new HashSet<StrainUse>();
    
    
    // Constructor --------------------------------------------------------------------------------
    public Strain() {

    	this.strain = "";
    	this.strainLong = "";
    	this.protein = "";
    	this.spectra = "";
    	this.pattern = "";
    	this.availability = "";
    	this.description = "";
    	this.contact = "";
    	this.price = "";
    	this.strainReferences = null;
    	this.strainUses = null;
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public String getStrain() {
    	return this.strain;
    }
    public String getStrainLong() {
    	return this.strainLong;
    }
    public String getProtein() {
    	return this.protein;
    }
    public String getSpectra() {
    	return this.spectra;
    }
    public String getPattern() {
    	return this.pattern;
    }
    public String getAvailability() {
    	return this.availability;
    }
    public String getDescription() {
    	return this.description;
    }
    public String getContact() {
    	return this.contact;
    }
    public String getPrice() {
    	return this.price;
    }
    public Date getCreationTime() {
    	return this.creationTime;
    }
    public Date getModificationTime() {
    	return this.modificationTime;
    }
    public long getVersion() {
        return this.version;
    }
    public Set<StrainReference> getStrainReferences() {
        return strainReferences;
    }
    public Set<StrainUse> getStrainUses() {
        return strainUses;
    }
 
    
    // Setters ------------------------------------------------------------------------------------
    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setStrain(String strain) {
    	this.strain = strain;
    }
    public void setStrainLong(String strainLong) {
    	this.strainLong = strainLong;
    }
    public void setProtein(String protein) {
    	this.protein = protein;
    }
    public void setSpectra(String spectra) {
    	this.spectra = spectra;
    }
    public void setPattern(String pattern) {
    	this.pattern = pattern;
    }
    public void setAvailability(String availability) {
    	this.availability = availability;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    public void setContact(String contact) {
    	this.contact = contact;
    }
    public void setPrice(String price) {
    	this.price = price;
    }
    public void setCreationTime(Date creationTime) {
    	this.creationTime = creationTime;
    }
    public void setModificationTime(Date modificationTime) {
    	this.modificationTime = modificationTime;
    }
    public void setVersion(long version) {
    	this.version = version;
    }
    public void setStrainReferences(Set<StrainReference> strainReferences) {
        this.strainReferences = strainReferences;
    }
    public void setStrainUses(Set<StrainUse> strainUses) {
        this.strainUses = strainUses;
    }


    // Getters As Strings -------------------------------------------------------------------------
    public String getOidAsString() {
    	return ObjectConverter.convert(this.oid, String.class);
    }
    public String getCreationTimeAsString() {
    	return ObjectConverter.convert(this.creationTime, String.class);
    }
    public String getModificationTimeAsString() {
    	return ObjectConverter.convert(this.modificationTime, String.class);
    }
    public String getVersionAsString() {
    	return ObjectConverter.convert(this.version, String.class);
    }
    
    
    // Setters From Strings -----------------------------------------------------------------------
    public void setCreationTimeFromString(String creationTime) {
    	this.creationTime = ObjectConverter.convert(creationTime, Date.class);
    }
    public void setModificationTimeFromString(String modificationTime) {
    	this.modificationTime = ObjectConverter.convert(modificationTime, Date.class);
    }

    
    // Helpers ------------------------------------------------------------------------------------
    public void addStrainReference(StrainReference strainReference) {
        this.strainReferences.add(strainReference);
    }
    public void removeStrainReference(StrainReference strainReference) {
        this.strainReferences.remove(strainReference);
    }
    
    public void addStrainUse(StrainUse strainUse) {
        this.strainUses.add(strainUse);
    }
    public void removeStrainUse(StrainUse strainUse) {
        this.strainUses.remove(strainUse);
    }
    

    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(Strain strain){

        if (this.getOid().equals(strain.getOid()) && 
        		this.getStrain().equals(strain.getStrain()) && 
        		this.getStrainLong().equals(strain.getStrainLong()) &&
        	    this.getProtein().equals(strain.getProtein()) && 
        	    this.getSpectra().equals(strain.getSpectra()) && 
        	    this.getPattern().equals(strain.getPattern()) && 
        	    this.getAvailability().equals(strain.getAvailability()) && 
        	    this.getDescription().equals(strain.getDescription()) && 
        	    this.getContact().equals(strain.getContact()) &&
        	    this.getPrice().equals(strain.getPrice()) &&
        	    this.getStrainReferences() == strain.getStrainReferences() && 
        	    this.getStrainUses() == strain.getStrainUses() 
        	    ) {

        	return true;
        }
        else {

        	return false;
        }
    }

    /*
     * The OID is unique for each Component.
     *  So this should compare Component by OID only.
     */
    @Override
    public boolean equals(Object other) {
    	
        return (other instanceof Strain) && (this.getOid() != null) ? this.getOid().equals(((Strain) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		String strain,
    		String strainLong,
    		String protein,    
    		String spectra,
    		String pattern,
    		String availability,
    		String description,
    		String contact,
    		String price,
    		Set<StrainReference> strainReferences,
    		Set<StrainUse> strainUses
    		) {

    	this.oid = oid;
    	this.strain = strain;
    	this.strainLong = strainLong;
    	this.protein = protein;    
    	this.spectra = spectra;
    	this.pattern = pattern;
    	this.availability = availability;
    	this.description = description;
		this.contact = contact;
    	this.price = price;
		this.strainReferences = strainReferences;
		this.strainUses = strainUses;
    }
    
    @PreUpdate
    public void preUpdate() {
    	
    	this.modificationTime = new Date();
    }
    
    @PrePersist
    public void prePersist() {
    	
        Date now = new Date();
        
        this.creationTime = now;
        this.modificationTime = now;
    }

    public String toString() {
    	
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }

    // Strain Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create Strain objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		String strain,
    		String strainLong,
    		String protein,    
    		String spectra,
    		String pattern,
    		String availability,
    		String description,
    		String contact,
    		String price,
    		Set<StrainReference> strainReferences,
    		Set<StrainUse> strainUses
    		) {
    	
        return new Builder(
        		oid,
        		strain,
        		strainLong,
        		protein,    
        		spectra,
        		pattern,
        		availability,
        		description,
        		contact,
        		price,
        		strainReferences,
        		strainUses
        		);
    }
    
    /**
     * A Builder class used to create new Strain objects.
     */
    public static class Builder {
    	
        Strain built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		String strain,
        		String strainLong,
        		String protein,    
        		String spectra,
        		String pattern,
        		String availability,
        		String description,
        		String contact,
        		String price,
        		Set<StrainReference> strainReferences,
        		Set<StrainUse> strainUses
        		) {
        	
            built = new Strain();
            
        	built.oid = oid;
        	built.strain = strain;
        	built.strainLong = strainLong;
        	built.protein = protein;    
        	built.spectra = spectra;
        	built.pattern = pattern;
        	built.availability = availability;
        	built.description = description;
    		built.contact = contact;
        	built.price = price;
    		built.strainReferences = strainReferences;
    		built.strainUses = strainUses;
        }

        /**
         * Builds the new Strain object.
         * 
         * @return this. The created Strain object.
         */
        public Strain build() {
        	
            return built;
        }
    }

    
    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	result = prime * result + ( ( this.strain == null ) ? 0 : this.strain.hashCode() );
    	result = prime * result + ( ( this.strainLong == null ) ? 0 : this.strainLong.hashCode() );
    	result = prime * result + ( ( this.protein == null ) ? 0 : this.protein.hashCode() );    
    	result = prime * result + ( ( this.spectra == null ) ? 0 : this.spectra.hashCode() );
    	result = prime * result + ( ( this.pattern == null ) ? 0 : this.pattern.hashCode() );
    	result = prime * result + ( ( this.availability == null ) ? 0 : this.availability.hashCode() );
    	result = prime * result + ( ( this.description == null ) ? 0 : this.description.hashCode() );
    	result = prime * result + ( ( this.contact == null ) ? 0 : this.contact.hashCode() );
    	result = prime * result + ( ( this.price == null ) ? 0 : this.price.hashCode() );

    	return result;
    }
    

    public int compareTo(Strain o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByStrainAsc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o1.strain.compareTo(strain_o2.strain);
        }
    }
    public static class OrderByStrainDesc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o2.strain.compareTo(strain_o1.strain);
        }
    }

    public static class OrderByStrainLongAsc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o1.strainLong.compareTo(strain_o2.strainLong);
        }
    }
    public static class OrderByStrainLongDesc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o2.strainLong.compareTo(strain_o1.strainLong);
        }
    }

    public static class OrderByProteinAsc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o1.protein.compareTo(strain_o2.protein);
        }
    }
    public static class OrderByProteinDesc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o2.protein.compareTo(strain_o1.protein);
        }
    }

    public static class OrderBySpectraAsc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o1.spectra.compareTo(strain_o2.spectra);
        }
    }
    public static class OrderBySpectraDesc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o2.spectra.compareTo(strain_o1.spectra);
        }
    }
    
    public static class OrderByPatternAsc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o1.pattern.compareTo(strain_o2.pattern);
        }
    }
    public static class OrderByPatternDesc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o2.pattern.compareTo(strain_o1.pattern);
        }
    }

    public static class OrderByAvailabilityAsc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o1.availability.compareTo(strain_o2.availability);
        }
    }
    public static class OrderByAvailabilityDesc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o2.availability.compareTo(strain_o1.availability);
        }
    }

    public static class OrderByDescriptionAsc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o1.description.compareTo(strain_o2.description);
        }
    }
    public static class OrderByDescriptionDesc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o2.description.compareTo(strain_o1.description);
        }
    }

    public static class OrderByContactAsc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o1.contact.compareTo(strain_o2.contact);
        }
    }
    public static class OrderByContactDesc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o2.contact.compareTo(strain_o1.contact);
        }
    }
	
    public static class OrderByPriceAsc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o1.price.compareTo(strain_o2.price);
        }
    }
    public static class OrderByPriceDesc implements Comparator<Strain> {

        public int compare(Strain strain_o1, Strain strain_o2) {

        	return strain_o2.price.compareTo(strain_o1.price);
        }
    }

}
