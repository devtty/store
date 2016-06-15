package org.devtty.store.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Denis Renning
 * 
 * 
 */
@Entity
@Table(name = "ST_COLLECTION")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_COLLECTION")
public class Collection extends AbstractPersistable{
    
    @OneToMany(mappedBy = "collection")
    private List<Item> items;
    
    @Temporal(TemporalType.DATE)
    private Date datum;
    
    private String infos;
    
    @Enumerated(EnumType.STRING)
    private CollectionStatus status;
    
    private String outNr;
    
    private String outVehicleId;
    
    private String outDestination;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date outIncome;
    
    private Integer weight;
    
    private BigDecimal wga;
   
    private BigDecimal wgb;
    
    private BigDecimal wgc;
    
    private BigDecimal wgd;
    
    private BigDecimal wge;
    
    private BigDecimal wgf;
    
    private BigDecimal wgg;
    
    private BigDecimal wgh;
        
}
