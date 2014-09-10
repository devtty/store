package org.devtty.store.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Denis Renning
 */
@Entity
@Table(name = "ST_ITEM")
public class Item implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clientRef;
    private String consolidate;
    private String startlocation;
    private String startcorporation;
    private String name;
    private String inMProblem;
    private String docs;
    private String bvdInfo;
    private String vehicleNo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startdate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date indate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date outDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date customsIn;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastChange;
    
    private Integer kolli;
    private Integer paletten;
    
    private Double inW;
    private Double inV;
    private Double currentWeight;
    
    private BigDecimal storeUnit;
    private BigDecimal key;
    private BigDecimal lid;
    private BigDecimal splitId;
    
    private boolean inMOk;
    private boolean inWOk;
    private boolean currentWeightOk;
    private boolean t1;
    private boolean adr;
    private boolean ex;
    
    private ItemStatus status;
    
    @ManyToOne
    private Collection collection;
    
    @ManyToOne
    private Store store;
    
    @ManyToOne
    private Client client;
    
    @ManyToOne
    private User lastChangeBy;
            
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
    }

    public String getConsolidate() {
        return consolidate;
    }

    public void setConsolidate(String consolidate) {
        this.consolidate = consolidate;
    }

    public String getStartlocation() {
        return startlocation;
    }

    public void setStartlocation(String startlocation) {
        this.startlocation = startlocation;
    }

    public String getStartcorporation() {
        return startcorporation;
    }

    public void setStartcorporation(String startcorporation) {
        this.startcorporation = startcorporation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInMProblem() {
        return inMProblem;
    }

    public void setInMProblem(String inMProblem) {
        this.inMProblem = inMProblem;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    public String getBvdInfo() {
        return bvdInfo;
    }

    public void setBvdInfo(String bvdInfo) {
        this.bvdInfo = bvdInfo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Date getCustomsIn() {
        return customsIn;
    }

    public void setCustomsIn(Date customsIn) {
        this.customsIn = customsIn;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Integer getKolli() {
        return kolli;
    }

    public void setKolli(Integer kolli) {
        this.kolli = kolli;
    }

    public Integer getPaletten() {
        return paletten;
    }

    public void setPaletten(Integer paletten) {
        this.paletten = paletten;
    }

    public Double getInW() {
        return inW;
    }

    public void setInW(Double inW) {
        this.inW = inW;
    }

    public Double getInV() {
        return inV;
    }

    public void setInV(Double inV) {
        this.inV = inV;
    }

    public Double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public BigDecimal getStoreUnit() {
        return storeUnit;
    }

    public void setStoreUnit(BigDecimal storeUnit) {
        this.storeUnit = storeUnit;
    }

    public BigDecimal getKey() {
        return key;
    }

    public void setKey(BigDecimal key) {
        this.key = key;
    }

    public BigDecimal getLid() {
        return lid;
    }

    public void setLid(BigDecimal lid) {
        this.lid = lid;
    }

    public BigDecimal getSplitId() {
        return splitId;
    }

    public void setSplitId(BigDecimal splitId) {
        this.splitId = splitId;
    }

    public boolean isInMOk() {
        return inMOk;
    }

    public void setInMOk(boolean inMOk) {
        this.inMOk = inMOk;
    }

    public boolean isInWOk() {
        return inWOk;
    }

    public void setInWOk(boolean inWOk) {
        this.inWOk = inWOk;
    }

    public boolean isCurrentWeightOk() {
        return currentWeightOk;
    }

    public void setCurrentWeightOk(boolean currentWeightOk) {
        this.currentWeightOk = currentWeightOk;
    }

    public boolean isT1() {
        return t1;
    }

    public void setT1(boolean t1) {
        this.t1 = t1;
    }

    public boolean isAdr() {
        return adr;
    }

    public void setAdr(boolean adr) {
        this.adr = adr;
    }

    public boolean isEx() {
        return ex;
    }

    public void setEx(boolean ex) {
        this.ex = ex;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.devtty.store.entity.Item[ id=" + id + " ]";
    }
    
}
