package com.roslin.mwicks.spring.narf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.roslin.mwicks.spring.narf.dto.online.DTOOrder;

import com.roslin.mwicks.spring.narf.format.CustomDateToStringStyle;

import com.roslin.mwicks.utility.ObjectConverter;


/**
 * An entity class which contains the information of a single Order Table Row.
 * @author Mike Wicks
 * @Entity
 * @Transactional
 */

@Entity
@Table(name = "ncs_order")
public class Order implements Serializable, Comparable<Order>{
    
    // Constants ----------------------------------------------------------------------------------

	// Properties ---------------------------------------------------------------------------------

    // nlo_oid bigint(20)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "nlo_oid", nullable = true)
    private Long oid;
    
    // nlo_required_date
    @Column(name = "nlo_required_date", nullable = true)
    private Date requiredDate;
    
    // nlo_supplied_date
    @Column(name = "nlo_supplied_date", nullable = true)
    private Date suppliedDate;
    
    // nlo_study_number
    @Column(name = "nlo_study_number", nullable = false)
    private String study;
    
    // nlo_cost_code
    @Column(name = "nlo_cost_code", nullable = false)
    private String code;
    
    // nlo_customer_comment
    @Column(name = "nlo_customer_comment", nullable = false)
    private String customerComment;

    // nlo_supplier_comment
    @Column(name = "nlo_supplier_comment", nullable = true)
    private String supplierComment;

    // ncs__order_bird_order_line
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_order_bird_order_line", 
               joinColumns = { @JoinColumn(name = "nlo_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "nbol_oid") })
    private Set<BirdOrderLine> birdOrderLines = new HashSet<BirdOrderLine>();

    // ncs__order_egg_order_line
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_order_egg_order_line", 
               joinColumns = { @JoinColumn(name = "nlo_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "neol_oid") })
    private Set<EggOrderLine> eggOrderLines = new HashSet<EggOrderLine>();

    // ncs__order_embryo_order_line
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ncs_order_embryo_order_line", 
               joinColumns = { @JoinColumn(name = "nlo_oid") }, 
               inverseJoinColumns = { @JoinColumn(name = "nmol_oid") })
    private Set<EmbryoOrderLine> embryoOrderLines = new HashSet<EmbryoOrderLine>();

    // OrderStatus_oid
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "OrderStatus_oid", referencedColumnName = "ncos_oid") 
    private OrderStatus orderStatus;
    
    // OrderCollection_oid
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "OrderCollection_oid", referencedColumnName = "ncoc_oid") 
    private OrderCollection orderCollection;
    
    // OrderCollection_oid
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "OrderType_oid", referencedColumnName = "ncot_oid") 
    private OrderType orderType;
    
    // nlo_customer_oid 
	@Column(name = "nlo_customer_oid", nullable = true)
    private Long customer;

    // nlo_editor_oid
	@Column(name = "nlo_editor_oid", nullable = true)
    private Long editor;

    // nlo_supplier_oid
	@Column(name = "nlo_supplier_oid", nullable = true)
    private Long supplier;


	@Column(name = "nlo_creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "nlo_modification_time", nullable = true)
    private Date modificationTime;
    
    @Version
    @Column(name = "nlo_version", nullable = false)
    private long version;
    
    
    // Constructor --------------------------------------------------------------------------------
    public Order() {

    	this.oid = (long) 0;

    	Date now = new Date();

    	this.requiredDate = now;
    	this.suppliedDate = now;
    	
    	this.study = "";
    	this.code = "";
    	this.customerComment = "";
    	this.supplierComment = "";
    	
    	this.birdOrderLines = null;
    	this.eggOrderLines = null;
    	this.embryoOrderLines = null;
    	
    	this.orderStatus = null;
    	this.orderCollection = null;
    	this.orderType = null;

    	this.customer = (long) 0;
    	this.editor = (long) 0;
    	this.supplier = (long) 0;
    }


    // Getters ------------------------------------------------------------------------------------
    public Long getOid() {
    	return this.oid;
    }
    public Date getRequiredDate() {
    	return this.requiredDate;
    }
    public Date getSuppliedDate() {
    	return this.suppliedDate;
    }
    public String getStudy() {
    	return this.study;
    }
    public String getCode() {
    	return this.code;
    }
    public String getCustomerComment() {
    	return this.customerComment;
    }
    public String getSupplierComment() {
    	return this.supplierComment;
    }

    public Set<BirdOrderLine> getBirdOrderLines() {
        return birdOrderLines;
    }
    public Set<EggOrderLine> getEggOrderLines() {
        return eggOrderLines;
    }
    public Set<EmbryoOrderLine> getEmbryoOrderLines() {
        return embryoOrderLines;
    }
    public OrderStatus getOrderStatus() {
    	return this.orderStatus;
    }
    public OrderCollection getOrderCollection() {
    	return this.orderCollection;
    }
    public OrderType getOrderType() {
    	return this.orderType;
    }

    public Long getCustomer() {
    	return this.customer;
    }
    public Long getEditor() {
    	return this.editor;
    }
    public Long getSupplier() {
    	return this.supplier;
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
    public void setRequiredDate(Date requiredDate) {
    	this.requiredDate = requiredDate;
    }
    public void setSuppliedDate(Date suppliedDate) {
    	this.suppliedDate = suppliedDate;
    }
    public void setStudy(String study) {
    	this.study = study;
    }
    public void setCode(String code) {
    	this.code = code;
    }
    public void setCustomerComment(String customerComment) {
    	this.customerComment = customerComment;
    }
    public void setSupplierComment(String supplierComment) {
    	this.supplierComment = supplierComment;
    }

    public void setBirdOrderLines(Set<BirdOrderLine> birdOrderLines) {
        this.birdOrderLines = birdOrderLines;
    }
    public void setEggOrderLines(Set<EggOrderLine> eggOrderLines) {
        this.eggOrderLines = eggOrderLines;
    }
    public void setEmbryoOrderLines(Set<EmbryoOrderLine> embryoOrderLines) {
        this.embryoOrderLines = embryoOrderLines;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
    	this.orderStatus = orderStatus;
    }
    public void setOrderCollection(OrderCollection orderCollection) {
    	this.orderCollection = orderCollection;
    }
    public void setOrderType(OrderType orderType) {
    	this.orderType = orderType;
    }

    public void setCustomer(Long customer) {
    	this.customer = customer;
    }
    public void setEditor(Long editor) {
    	this.editor = editor;
    }
    public void setSupplier(Long supplier) {
    	this.supplier = supplier;
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
    public void addBirdOrderLine(BirdOrderLine birdorderline) {
        this.birdOrderLines.add(birdorderline);
    }
    public void removeBirdOrderLine(BirdOrderLine birdorderline) {
        this.birdOrderLines.remove(birdorderline);
    }
    
    public void addEggOrderLine(EggOrderLine eggorderline) {
        this.eggOrderLines.add(eggorderline);
    }
    public void removeEggOrderLine(EggOrderLine eggorderline) {
        this.eggOrderLines.remove(eggorderline);
    }
    
    public void addEmbryoOrderLine(EmbryoOrderLine embryoorderline) {
        this.embryoOrderLines.add(embryoorderline);
    }
    public void removeEmbryoOrderLine(EmbryoOrderLine embryoorderline) {
        this.embryoOrderLines.remove(embryoorderline);
    }
    
    public String formatDate(Date date) {

        String formatString = "dd MMMM yyyy";
        SimpleDateFormat formatddMMMyyy = new SimpleDateFormat(formatString);
		//Date parsed = new Date();

        return formatddMMMyyy.format(date);
    }
    
    public String formatNewEmail(String customerEmail) {
    	
    	String birdEmail = "";

        Set<BirdOrderLine> BirdOrderLines = this.getBirdOrderLines();
        
        if ( BirdOrderLines != null ) {

        	Iterator<BirdOrderLine> iteratorBirdOrderLines = BirdOrderLines.iterator();
            
            while (iteratorBirdOrderLines.hasNext()) {
        		
            	BirdOrderLine birdorderline = iteratorBirdOrderLines.next();

				birdEmail = birdEmail + birdorderline.toEmailString();
            }
        }

    	String eggEmail = "";

        Set<EggOrderLine> EggOrderLines = this.getEggOrderLines();
        
        if ( EggOrderLines != null ) {

        	Iterator<EggOrderLine> iteratorEggOrderLines = EggOrderLines.iterator();
            
            while (iteratorEggOrderLines.hasNext()) {
        		
            	EggOrderLine eggorderline = iteratorEggOrderLines.next();

				eggEmail = eggEmail + eggorderline.toEmailString();
            }
        }
        
    	String embryoEmail = "";

        Set<EmbryoOrderLine> EmbryoOrderLines = this.getEmbryoOrderLines();
        
        if ( EmbryoOrderLines != null ) {

        	Iterator<EmbryoOrderLine> iteratorEmbryoOrderLines = EmbryoOrderLines.iterator();
            
            while (iteratorEmbryoOrderLines.hasNext()) {
        		
            	EmbryoOrderLine embryoorderline = iteratorEmbryoOrderLines.next();

				embryoEmail = embryoEmail + embryoorderline.toEmailString();
            }

        }

        final StringBuilder builder = new StringBuilder();

        builder
            .append("\n---------")
            .append("\nNEW ORDER from ")
            .append(customerEmail)
            .append("\n---------")
			.append("\nDate Required    : ")
			.append(formatDate(this.getRequiredDate()))
			.append("\nStudy            : ")
			.append(this.getStudy())
			.append("\nCode             : ")
			.append(this.getCode())
			.append("\nCustomer Comment : ")
			.append(this.getCustomerComment())
			.append(birdEmail)
			.append(eggEmail)
			.append(embryoEmail);

        return builder.toString();
    }


    public String formatClosedEmail(String customerEmail, String editorEmail, String supplierEmail) {
    	
    	String birdEmail = "";

        Set<BirdOrderLine> BirdOrderLines = this.getBirdOrderLines();
        
        if ( BirdOrderLines != null ) {

        	Iterator<BirdOrderLine> iteratorBirdOrderLines = BirdOrderLines.iterator();
            
            while (iteratorBirdOrderLines.hasNext()) {
        		
            	BirdOrderLine birdorderline = iteratorBirdOrderLines.next();

				birdEmail = birdEmail + birdorderline.toEmailString();
            }
        }

    	String eggEmail = "";

        Set<EggOrderLine> EggOrderLines = this.getEggOrderLines();
        
        if ( EggOrderLines != null ) {

        	Iterator<EggOrderLine> iteratorEggOrderLines = EggOrderLines.iterator();
            
            while (iteratorEggOrderLines.hasNext()) {
        		
            	EggOrderLine eggorderline = iteratorEggOrderLines.next();

				eggEmail = eggEmail + eggorderline.toEmailString();
            }
        }
        
    	String embryoEmail = "";

        Set<EmbryoOrderLine> EmbryoOrderLines = this.getEmbryoOrderLines();
        
        if ( EmbryoOrderLines != null ) {

        	Iterator<EmbryoOrderLine> iteratorEmbryoOrderLines = EmbryoOrderLines.iterator();
            
            while (iteratorEmbryoOrderLines.hasNext()) {
        		
            	EmbryoOrderLine embryoorderline = iteratorEmbryoOrderLines.next();

				embryoEmail = embryoEmail + embryoorderline.toEmailString();
            }

        }

        final StringBuilder builder = new StringBuilder();

        builder
            .append("\n---------")
            .append("\nCOMPLETED ORDER for ")
            .append(customerEmail)
            .append("\n---------")
			.append("\nProcessed By        ")
            .append(editorEmail)
			.append("\nSupplied By         ")
            .append(supplierEmail)
			.append("\nDate Required    : ")
			.append(formatDate(this.getRequiredDate()))
			.append("\nStudy            : ")
			.append(this.getStudy())
			.append("\nCode             : ")
			.append(this.getCode())
			.append("\nCustomer Comment : ")
			.append(this.getCustomerComment())
			.append(birdEmail)
			.append(eggEmail)
			.append(embryoEmail);

        return builder.toString();
    }


    public DTOOrder convertToDTOOrder() {
    	
        int birdRequired = 0;
        int birdSupplied = 0;
        int birdAge = 0;
        BirdOrderLineSex birdOrderLineSex = null;
        BirdOrderLineDateFormat birdOrderLineDateFormat = null;
        Organism birdOrganism = null;

        Set<BirdOrderLine> BirdOrderLines = this.getBirdOrderLines();
        
        if ( !BirdOrderLines.isEmpty() ) {

        	Iterator<BirdOrderLine> iteratorBirdOrderLines = BirdOrderLines.iterator();
            
            while (iteratorBirdOrderLines.hasNext()) {
        		
            	BirdOrderLine birdorderline = iteratorBirdOrderLines.next();

            	birdRequired = birdorderline.getRequired();
            	birdSupplied = birdorderline.getSupplied();
            	birdAge = birdorderline.getAge();
            	birdOrderLineSex = birdorderline.getBirdOrderLineSex();
            	birdOrderLineDateFormat = birdorderline.getBirdOrderLineDateFormat();
            	birdOrganism = birdorderline.getOrganism();
            }
        }

        int eggRequired = 0;
        int eggSupplied = 0;
        EggOrderLineFertilised eggOrderLineFertilised = null;
        Organism eggOrganism = null;

        Set<EggOrderLine> EggOrderLines = this.getEggOrderLines();
        
        if ( !EggOrderLines.isEmpty() ) {

        	Iterator<EggOrderLine> iteratorEggOrderLines = EggOrderLines.iterator();
            
            while (iteratorEggOrderLines.hasNext()) {
        		
            	EggOrderLine eggorderline = iteratorEggOrderLines.next();

            	eggRequired = eggorderline.getRequired();
            	eggSupplied = eggorderline.getSupplied();
            	eggOrderLineFertilised = eggorderline.getEggOrderLineFertilised();
            	eggOrganism = eggorderline.getOrganism();
            }
        }
        
        int embryoRequired = 0;
        int embryoSupplied = 0;
        EmbryoOrderLineIncubation embryoOrderLineIncubation = null;
        Organism embryoOrganism = null;

        Set<EmbryoOrderLine> EmbryoOrderLines = this.getEmbryoOrderLines();
        
        if ( !EmbryoOrderLines.isEmpty() ) {

        	Iterator<EmbryoOrderLine> iteratorEmbryoOrderLines = EmbryoOrderLines.iterator();
            
            while (iteratorEmbryoOrderLines.hasNext()) {
        		
            	EmbryoOrderLine embryoorderline = iteratorEmbryoOrderLines.next();

            	embryoRequired = embryoorderline.getRequired();
            	embryoSupplied = embryoorderline.getSupplied();
            	embryoOrderLineIncubation = embryoorderline.getEmbryoOrderLineIncubation();
            	embryoOrganism = embryoorderline.getOrganism();
            }

        }

        DTOOrder dtoorder = new DTOOrder();

		dtoorder.setOid( this.getOid() );

		dtoorder.setCreatedDate( this.getCreationTime() );
		dtoorder.setRequiredDate( this.getRequiredDate() );
		dtoorder.setSuppliedDate( this.getSuppliedDate() );
		dtoorder.setStudy( this.getStudy() );
		dtoorder.setCode( this.getCode() );
		dtoorder.setCustomerComment( this.getCustomerComment() );
		dtoorder.setSupplierComment( this.getSupplierComment() );
		dtoorder.setCustomer( this.getCustomer() );
		dtoorder.setEditor( this.getEditor() );
		dtoorder.setSupplier( this.getSupplier() );
		dtoorder.setCustomerEmail( "" );
		dtoorder.setEditorEmail( "" );
		dtoorder.setSupplierEmail( "" );
		dtoorder.setCustomerOrganisation( "" );
		dtoorder.setOrderStatus( this.getOrderStatus() );
		dtoorder.setOrderCollection( this.getOrderCollection() );
		dtoorder.setOrderType( this.getOrderType() );

		dtoorder.setBirdRequired( birdRequired );
		dtoorder.setBirdSupplied( birdSupplied );
		dtoorder.setBirdAge( birdAge );
		dtoorder.setBirdOrderLineSex( birdOrderLineSex );
		dtoorder.setBirdOrderLineDateFormat( birdOrderLineDateFormat );
		dtoorder.setBirdOrganism( birdOrganism );

		dtoorder.setEggRequired( eggRequired );
		dtoorder.setEggSupplied (eggSupplied );
		dtoorder.setEggOrderLineFertilised( eggOrderLineFertilised );
		dtoorder.setEggOrganism( eggOrganism );

		dtoorder.setEmbryoRequired( embryoRequired );
		dtoorder.setEmbryoSupplied( embryoSupplied );
		dtoorder.setEmbryoOrderLineIncubation( embryoOrderLineIncubation );
		dtoorder.setEmbryoOrganism( embryoOrganism );

		return dtoorder;
    }
    
    /*
     * Is this Component the same as the Supplied Component?
     */
    public boolean isSameAs(Order order){

        if (this.getOid().equals(order.getOid()) && 
        		this.getRequiredDate().equals(order.getRequiredDate()) && 
        		this.getSuppliedDate().equals(order.getSuppliedDate()) && 
        		this.getStudy().equals(order.getStudy()) && 
        		this.getCode().equals(order.getCode()) && 
        		this.getCustomerComment().equals(order.getCustomerComment()) &&
        		this.getSupplierComment().equals(order.getSupplierComment()) &&
        	    this.getBirdOrderLines() == order.getBirdOrderLines() && 
        	    this.getEggOrderLines() == order.getEggOrderLines() &&
        	    this.getEmbryoOrderLines() == order.getEmbryoOrderLines() &&
                this.getOrderStatus() == order.getOrderStatus() && 
                this.getOrderCollection() == order.getOrderCollection() && 
                this.getOrderType() == order.getOrderType() && 
                this.getCustomer() == order.getCustomer() &&
                this.getEditor() == order.getEditor() &&
                this.getSupplier() == order.getSupplier()
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
    	
        return (other instanceof Order) && (this.getOid() != null) ? this.getOid().equals(((Order) other).getOid()) : (other == this);
    }
    

    public void update(
    		long oid,
    		Date requiredDate,
    		Date suppliedDate,
    		String study,
    		String code,
    		String customerComment,
    		String supplierComment,
    		Set<BirdOrderLine> BirdOrderLines,
    		Set<EggOrderLine> EggOrderLines,
    		Set<EmbryoOrderLine> EmbryoOrderLines,
    		OrderStatus OrderStatus,
    		OrderCollection OrderCollection,
    		OrderType OrderType,
    		long customer,
    		long editor,
    		long supplier
    		) {

    	this.oid = oid;
    	this.requiredDate = requiredDate;
    	this.suppliedDate = suppliedDate;
    	this.study = study;
    	this.code = code;
    	this.customerComment = customerComment;
    	this.supplierComment = supplierComment;
		this.birdOrderLines = BirdOrderLines;
		this.eggOrderLines = EggOrderLines;
		this.embryoOrderLines = EmbryoOrderLines;
    	this.orderStatus = OrderStatus;
    	this.orderCollection = OrderCollection;
    	this.orderType = OrderType;
    	this.customer = customer;
    	this.editor = editor;
    	this.supplier = supplier;
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

    // Order Builder ---------------------------------------------------------------------
    /**
     * Gets a builder which is used to create Order objects.
     */
    public static Builder getBuilder(
    		Long oid,
    		Date requiredDate,
    		Date suppliedDate,
    		String study,
    		String code,
    		String customerComment,
    		String supplierComment,
    		Set<BirdOrderLine> BirdOrderLines,
    		Set<EggOrderLine> EggOrderLines,
    		Set<EmbryoOrderLine> EmbryoOrderLines,
    		OrderStatus OrderStatus,
    		OrderCollection OrderCollection,
    		OrderType OrderType,
    		Long customer,
    		Long editor,
    		Long supplier
    		) {
    	
        return new Builder(
        		oid,
        		requiredDate,
        		suppliedDate,
            	study,
            	code,
            	customerComment,
            	supplierComment,
        		BirdOrderLines,
        		EggOrderLines,
        		EmbryoOrderLines,
        		OrderStatus,
        		OrderCollection,
        		OrderType,
        		customer,
        		editor,
        		supplier
        		);
    }
    
    /**
     * A Builder class used to create new Order objects.
     */
    public static class Builder {
    	
        Order built;

        /**
         * Creates a new Builder instance.
         */
        Builder(
        		Long oid,
        		Date requiredDate,
        		Date suppliedDate,
        		String study,
        		String code,
        		String customerComment,
        		String supplierComment,
        		Set<BirdOrderLine> birdOrderLines,
        		Set<EggOrderLine> eggOrderLines,
        		Set<EmbryoOrderLine> embryoOrderLines,
        		OrderStatus orderStatus,
        		OrderCollection orderCollection,
        		OrderType orderType,
        		Long customer,
        		Long editor,
        		Long supplier
        		) {
        	
            built = new Order();
            
        	built.oid = oid;
        	built.requiredDate = requiredDate;
        	built.suppliedDate = suppliedDate;
        	built.study = study;
        	built.code = code;
        	built.customerComment = customerComment;
        	built.supplierComment = supplierComment;
    		built.birdOrderLines = birdOrderLines;
    		built.eggOrderLines = eggOrderLines;
    		built.embryoOrderLines = embryoOrderLines;
        	built.orderStatus = orderStatus;
        	built.orderCollection = orderCollection;
        	built.orderType = orderType;
        	built.customer = customer;
        	built.editor = editor;
        	built.supplier = supplier;
        }

        /**
         * Builds the new Order object.
         * 
         * @return this. The created Order object.
         */
        public Order build() {
        	
            return built;
        }
    }

    
    @Override
    public int hashCode() {
    
    	final int prime = 31;
    	int result = 1;
        
    	result = prime * result + ( ( this.oid == null ) ? 0 : this.oid.hashCode() );
    	result = prime * result + ( ( this.customerComment == null ) ? 0 : this.customerComment.hashCode() );
    	result = prime * result + ( ( this.supplierComment == null ) ? 0 : this.supplierComment.hashCode() );

    	return result;
    }
    

    public int compareTo(Order o) {
        return this.getOid() > o.getOid() ? 1 : (this.getOid() < o.getOid() ? -1 : 0);
    }


    public static class OrderByRequiredDateAsc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o1.requiredDate.compareTo(order_o2.requiredDate);
        }
    }
    public static class OrderByRequiredDateDesc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o2.requiredDate.compareTo(order_o1.requiredDate);
        }
    }

    public static class OrderBySuppliedDateAsc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o1.suppliedDate.compareTo(order_o2.suppliedDate);
        }
    }
    public static class OrderBySuppliedDateDesc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o2.suppliedDate.compareTo(order_o1.suppliedDate);
        }
    }
    
    public static class OrderByStudyAsc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o1.study.compareTo(order_o2.study);
        }
    }
    public static class OrderByStudyDesc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o2.study.compareTo(order_o1.study);
        }
    }

    public static class OrderByCodeAsc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o1.code.compareTo(order_o2.code);
        }
    }
    public static class OrderByCodeDesc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o2.code.compareTo(order_o1.code);
        }
    }

    public static class OrderByCustomerCommentAsc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o1.customerComment.compareTo(order_o2.customerComment);
        }
    }
    public static class OrderByCustomerCommentDesc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o2.customerComment.compareTo(order_o1.customerComment);
        }
    }

    public static class OrderBySupplierCommentAsc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o1.supplierComment.compareTo(order_o2.supplierComment);
        }
    }
    public static class OrderBySupplierCommentDesc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o2.supplierComment.compareTo(order_o1.supplierComment);
        }
    }

    public static class OrderByCreatedAsc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o1.creationTime.compareTo(order_o2.creationTime);
        }
    }
    public static class OrderByCreatedDesc implements Comparator<Order> {

        public int compare(Order order_o1, Order order_o2) {

        	return order_o2.creationTime.compareTo(order_o1.creationTime);
        }
    }


	
}
