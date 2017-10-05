package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;

/**
 * An entity class which contains the information of a single Organism Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_organism")
@Transactional
public class Organism implements Serializable, Comparable<Organism>{
    
    // Constants ----------------------------------------------------------------------------------


	// Properties ---------------------------------------------------------------------------------

    // noo_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "noo_oid", nullable = true)
    private Long oid;
    
    // organism_name
    @Column(name = "noo_name", nullable = false)
    private String name;

    @Column(name = "noo_creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "noo_modification_time", nullable = true)
    private Date modificationTime;
    
    @Version
    @Column(name = "noo_version", nullable = false)
    private long version;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_organism_line", 
               joinColumns = { @JoinColumn(name = "noo_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "ncl_oid") })
    private Set<Line> lines = new HashSet<Line>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_organism_strain", 
               joinColumns = { @JoinColumn(name = "noo_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "ncs_oid") })
    private Set<Strain> strains = new HashSet<Strain>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_organism_avian", 
               joinColumns = { @JoinColumn(name = "nav_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "ncs_oid") })
    private Set<Avian> avians = new HashSet<Avian>();
    
    
    // Constructor --------------------------------------------------------------------------------
    public Organism() {

    	this.name = "";

    	this.lines = null;
    	this.strains = null;
    	this.avians = null;
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public String getName() {
    	return this.name;
    }

    public Set<Line> getLines() {
        return this.lines;
    }
    public Set<Strain> getStrains() {
        return this.strains;
    }
    public Set<Avian> getAvians() {
        return this.avians;
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
 
    
    // Setters ------------------------------------------------------------------------------------
    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setName(String name) {
    	this.name = name;
    }

    public void setLines(Set<Line> lines) {
        this.lines = lines;
    }
    public void setStrains(Set<Strain> strains) {
        this.strains = strains;
    }
    public void setAvians(Set<Avian> avians) {
        this.avians = avians;
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
    public void addLine(Line Line) {
        this.lines.add(Line);
    }
    public void addStrain(Strain strain) {
        this.strains.add(strain);
    }
    public void addAvian(Avian avian) {
        this.avians.add(avian);
    }

    public void removeLine(Line Line) {
        this.lines.remove(Line);
    }
    public void removeStrain(Strain strain) {
        this.strains.remove(strain);
    }
    public void removeAvian(Avian avian) {
        this.avians.remove(avian);
    }
    
    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(Organism organism){

        if (this.getOid().equals(organism.getOid()) && 
        		this.getName().equals(organism.getName()) && 
        		this.getLines().equals(organism.getLines()) && 
        		this.getStrains().equals(organism.getStrains()) && 
        		this.getAvians().equals(organism.getAvians())
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
    	
        return (other instanceof Organism) && (this.getOid() != null) ? this.getOid().equals(((Organism) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		String name,
    		Set<Line> lines,
    		Set<Strain> strains,
    		Set<Avian> avians
    		) {

    	
    	this.oid = oid;
    	this.name = name;

    	this.lines = lines;
    	this.strains = strains;
    	this.avians = avians;
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

    // Organism Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create Organism objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		String name,
    		Set<Line> lines,
    		Set<Strain> strains,
    		Set<Avian> avians
    		) {
    	
        return new Builder(
        		oid,
        		name,
        		lines,
        		strains,
        		avians
        		);
    }
    
    /**
     * A Builder class used to create new Organism objects.
     */
    public static class Builder {
    	
        Organism built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		String name,
        		Set<Line> lines,
        		Set<Strain> strains,
        		Set<Avian> avians
        		) {
        	
            built = new Organism();
            
        	built.oid = oid;
        	built.name = name;
    		built.lines = lines;
    		built.strains = strains;
    		built.avians = avians;
        }

        /**
         * Builds the new Organism object.
         */
        public Organism build() {
        	
            return built;
        }
    }

    
    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	result = prime * result + ( ( this.name == null ) ? 0 : this.name.hashCode() );

    	return result;
    }
    

    public int compareTo(Organism o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByOidAsc implements Comparator<Organism> {

        public int compare(Organism organism_o1, Organism organism_o2) {

        	return organism_o1.oid.compareTo(organism_o2.oid);
        }
    }
    public static class OrderByOidDesc implements Comparator<Organism> {

        public int compare(Organism organism_o1, Organism organism_o2) {

        	return organism_o2.oid.compareTo(organism_o1.oid);
        }
    }

    public static class OrderByNameAsc implements Comparator<Organism> {

        public int compare(Organism organism_o1, Organism organism_o2) {

        	return organism_o1.name.compareTo(organism_o2.name);
        }
    }
    public static class OrderByNameDesc implements Comparator<Organism> {

        public int compare(Organism organism_o1, Organism organism_o2) {

        	return organism_o2.name.compareTo(organism_o1.name);
        }
    }


}
