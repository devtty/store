package org.devtty.store.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Denis Renning
 * TODO similarities to Consolidation (proof)
 */
@Entity
@Table(name = "ST_CONTRACT")
public class Contract implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
        if (!(object instanceof Contract)) {
            return false;
        }
        Contract other = (Contract) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devtty.store.entity.Contract[ id=" + id + " ]";
    }
    
}
