package org.devtty.store.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Denis Renning
 * TODO similarities to Consolidation (proof)
 */
@Entity
@Table(name = "ST_CONTRACT")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_CONTRACT")
public class Contract extends AbstractPersistable{
    
    private String adr;
    private String additional;
    private String ass;
    private String contact;
    private String fixdate;
    private String fixterm;
    private String laddress;
    private String sender;
    private String vaddress;
    private String name;
    private String annotation;
    private String type;
   
    private Double bruttoweight;
    private Double insuranceamount;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date contractdate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date execdate;
    
    private Boolean createexa;
    private Boolean createt1;
    private Boolean insurance;
 
    private Integer status;

}
