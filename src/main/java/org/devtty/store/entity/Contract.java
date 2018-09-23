package org.devtty.store.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Denis Renning
 * TODO similarities to Consolidation (proof)
 */
@Entity
@Table(name = "ST_CONTRACT")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_CONTRACT")
public class Contract extends AbstractPersistable{
    
    @Size(max = 30)
    private String adr;
    
    @Size(max = 255)
    private String additional;
    
    @NotNull
    @Size(max = 1000)
    private String ass;
    
    @Size(max = 100)
    private String contact;
    private String fixdate;
    
    @Size(max = 30)
    private String fixterm;
    
    @Size(max = 100)
    @NotNull
    private String laddress;
    
    @Size(max = 50)
    private String sender;
    
    @Size(max = 500)
    @NotNull
    private String vaddress;
    
    @Size(max = 300)
    @NotNull
    private String name;
    
    @Size(max = 250)
    private String annotation;
    
    @Size(max = 50)
    private String type;
   
    @NotNull
    private Double bruttoweight;
    private Double insuranceamount;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date contractdate;
    
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date execdate;
    
    @NotNull
    private Boolean createexa;
    
    @NotNull
    private Boolean createt1;
    private Boolean insurance;
 
    private ContractStatus status;

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getAss() {
        return ass;
    }

    public void setAss(String ass) {
        this.ass = ass;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFixdate() {
        return fixdate;
    }

    public void setFixdate(String fixdate) {
        this.fixdate = fixdate;
    }

    public String getFixterm() {
        return fixterm;
    }

    public void setFixterm(String fixterm) {
        this.fixterm = fixterm;
    }

    public String getLaddress() {
        return laddress;
    }

    public void setLaddress(String laddress) {
        this.laddress = laddress;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBruttoweight() {
        return bruttoweight;
    }

    public void setBruttoweight(Double bruttoweight) {
        this.bruttoweight = bruttoweight;
    }

    public Double getInsuranceamount() {
        return insuranceamount;
    }

    public void setInsuranceamount(Double insuranceamount) {
        this.insuranceamount = insuranceamount;
    }

    public Date getContractdate() {
        return contractdate;
    }

    public void setContractdate(Date contractdate) {
        this.contractdate = contractdate;
    }

    public Date getExecdate() {
        return execdate;
    }

    public void setExecdate(Date execdate) {
        this.execdate = execdate;
    }

    public Boolean getCreateexa() {
        return createexa;
    }

    public void setCreateexa(Boolean createexa) {
        this.createexa = createexa;
    }

    public Boolean getCreatet1() {
        return createt1;
    }

    public void setCreatet1(Boolean createt1) {
        this.createt1 = createt1;
    }

    public Boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
    }

    public ContractStatus getStatus() {
        return status;
    }

    public void setStatus(ContractStatus status) {
        this.status = status;
    }
    
    

}
