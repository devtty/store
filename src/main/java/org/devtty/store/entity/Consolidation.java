package org.devtty.store.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

/**
 *
 * @author Denis Renning
 * TODO similarities to contract (proof)
 */
@Entity
@Table(name = "ST_CONSOLIDATION")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_CONSOLIDATION")
public class Consolidation extends AbstractPersistable{
    
    private Double bruttoWeight;
    private Double priceFreight;
    private Double priceExa;
    private Double priceT1;
    private Double priceInsurance;
    private Double priceRoadCharge;
    private Double priceOther;
    private Double priceVAT;
    private Double insuranceAmount;
    
    private ConsolidationStatus status;
    
    private Boolean insurance;
    private Boolean createT1;
    private Boolean createExa;
    private Boolean confirmation;
    
    private String vaddress;
    private String laddress;
    private String fixTerm;
    
    @Size(max = 30)
    private String adr;
    private String type;
    private String name;
    
    @Size(max = 250)
    private String annotation;
    private String contact;
    private String ass;
    private String reference;
    private String registerNo;
    private String sender;
    
    @Size(max = 250)
    private String additional;
    private String collection;
    private String ordernr;
    private String fixDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date execDate;
    private String contractDate;
    
}
