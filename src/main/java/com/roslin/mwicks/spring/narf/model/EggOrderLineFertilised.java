package com.roslin.mwicks.spring.narf.model;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.roslin.mwicks.spring.narf.enums.EnumFertilised;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;
 

@Entity
@Table(name="ncs_egg_order_line_fertilised")
public class EggOrderLineFertilised implements Serializable {
 
	@Id
	@Column(name = "neolf_oid", nullable = false)
    private Long oid; 
 
    @Column(name = "neolf_name", length=20, unique=true, nullable=false)
    private String name = EnumFertilised.FERTILISED.getEnumFertilised();


    public EggOrderLineFertilised() {

    	this.oid = (long) 0;
    	this.name = "";
    }

    public EggOrderLineFertilised(Long oid, String name) {

    	this.oid = oid;
    	this.name = name;
    }

    
    public Long getOid() {
    	return oid;
    }
    public String getName() {
        return name;
    }


    public void setOid(Long oid) {
    	this.oid = oid;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oid == null) ? 0 : oid.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof EggOrderLineFertilised))
            return false;
        EggOrderLineFertilised other = (EggOrderLineFertilised) obj;
        if (oid == null) {
            if (other.oid != null)
                return false;
        } else if (!oid.equals(other.oid))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
    	
        return ToStringBuilder.reflectionToString(this, new CustomDateToStringStyle());
    }

    
    public int compareTo(EggOrderLineFertilised o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByNameAsc implements Comparator<EggOrderLineFertilised> {

        public int compare(EggOrderLineFertilised eggorderlinefertilised_o1, EggOrderLineFertilised eggorderlinefertilised_o2) {

        	return eggorderlinefertilised_o1.name.compareTo(eggorderlinefertilised_o2.name);
        }
    }
    public static class OrderByNameDesc implements Comparator<EggOrderLineFertilised> {

        public int compare(EggOrderLineFertilised eggorderlinefertilised_o1, EggOrderLineFertilised eggorderlinefertilised_o2) {

        	return eggorderlinefertilised_o2.name.compareTo(eggorderlinefertilised_o1.name);
        }
    }

    public static class OrderByOidAsc implements Comparator<EggOrderLineFertilised> {

        public int compare(EggOrderLineFertilised eggorderlinefertilised_o1, EggOrderLineFertilised eggorderlinefertilised_o2) {

        	return eggorderlinefertilised_o1.oid.compareTo(eggorderlinefertilised_o2.oid);
        }
    }
    public static class OrderByOidDesc implements Comparator<EggOrderLineFertilised> {

        public int compare(EggOrderLineFertilised eggorderlinefertilised_o1, EggOrderLineFertilised eggorderlinefertilised_o2) {

        	return eggorderlinefertilised_o2.oid.compareTo(eggorderlinefertilised_o1.oid);
        }
    }


}
