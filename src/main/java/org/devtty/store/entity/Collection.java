package org.devtty.store.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Collection implements Serializable {
    @OneToMany(mappedBy = "collection")
    private List<Item> items;
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
        if (!(object instanceof Collection)) {
            return false;
        }
        Collection other = (Collection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devtty.store.entity.Collection[ id=" + id + " ]";
    }
    
}
