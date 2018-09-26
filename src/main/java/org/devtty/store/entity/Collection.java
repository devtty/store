package org.devtty.store.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
    
    @ManyToOne
    private Client client;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    private String infos;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private CollectionStatus status;
    
    private String outNr;
    
    private String outVehicleId;
    
    private String outDestination;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date outIncome;
    
    private BigDecimal weightDocumented;
    
    private BigDecimal weightBefore;
    
    private BigDecimal weightAfter;
    
    private BigDecimal wga;
   
    private BigDecimal wgb;
    
    private BigDecimal wgc;
    
    private BigDecimal wgd;
    
    private BigDecimal wge;
    
    private BigDecimal wgg;
    
    private BigDecimal wgh;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public CollectionStatus getStatus() {
        return status;
    }

    public void setStatus(CollectionStatus status) {
        this.status = status;
    }

    public String getOutNr() {
        return outNr;
    }

    public void setOutNr(String outNr) {
        this.outNr = outNr;
    }

    public String getOutVehicleId() {
        return outVehicleId;
    }

    public void setOutVehicleId(String outVehicleId) {
        this.outVehicleId = outVehicleId;
    }

    public String getOutDestination() {
        return outDestination;
    }

    public void setOutDestination(String outDestination) {
        this.outDestination = outDestination;
    }

    public Date getOutIncome() {
        return outIncome;
    }

    public void setOutIncome(Date outIncome) {
        this.outIncome = outIncome;
    }

    public BigDecimal getWeightDocumented() {
        return weightDocumented;
    }

    public void setWeightDocumented(BigDecimal weightDocumented) {
        this.weightDocumented = weightDocumented;
    }

    public BigDecimal getWeightBefore() {
        return weightBefore;
    }

    public void setWeightBefore(BigDecimal weightBefore) {
        this.weightBefore = weightBefore;
    }

    public BigDecimal getWeightAfter() {
        return weightAfter;
    }

    public void setWeightAfter(BigDecimal weightAfter) {
        this.weightAfter = weightAfter;
    }

    public BigDecimal getWga() {
        return wga;
    }

    public void setWga(BigDecimal wga) {
        this.wga = wga;
    }

    public BigDecimal getWgb() {
        return wgb;
    }

    public void setWgb(BigDecimal wgb) {
        this.wgb = wgb;
    }

    public BigDecimal getWgc() {
        return wgc;
    }

    public void setWgc(BigDecimal wgc) {
        this.wgc = wgc;
    }

    public BigDecimal getWgd() {
        return wgd;
    }

    public void setWgd(BigDecimal wgd) {
        this.wgd = wgd;
    }

    public BigDecimal getWge() {
        return wge;
    }

    public void setWge(BigDecimal wge) {
        this.wge = wge;
    }

    public BigDecimal getWgg() {
        return wgg;
    }

    public void setWgg(BigDecimal wgg) {
        this.wgg = wgg;
    }

    public BigDecimal getWgh() {
        return wgh;
    }

    public void setWgh(BigDecimal wgh) {
        this.wgh = wgh;
    }
    
    
        
}
