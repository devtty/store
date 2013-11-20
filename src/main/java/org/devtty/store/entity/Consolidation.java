package org.devtty.store.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Denis Renning
 * TODO similarities to contract (proof)
 */
@Entity
public class Consolidation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    private String adr;
    private String type;
    private String name;
    private String annotation;
    private String contact;
    private String ass;
    private String reference;
    private String registerNo;
    private String sender;
    private String additional;
    private String collection;
    private String ordernr;
    private String fixDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date execDate;
    private String contractDate;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consolidation)) {
            return false;
        }
        Consolidation other = (Consolidation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devtty.store.entity.Consolidation[ id=" + id + " ]";
    }
    
}
