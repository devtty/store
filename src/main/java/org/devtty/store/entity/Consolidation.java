package org.devtty.store.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne
    private Client client;
    
    @ManyToOne
    private Contractor contractor;
    
    @ManyToOne
    private Contract contract;
    private User createdBy;

    public Double getBruttoWeight() {
        return bruttoWeight;
    }

    public void setBruttoWeight(Double bruttoWeight) {
        this.bruttoWeight = bruttoWeight;
    }

    public Double getPriceFreight() {
        return priceFreight;
    }

    public void setPriceFreight(Double priceFreight) {
        this.priceFreight = priceFreight;
    }

    public Double getPriceExa() {
        return priceExa;
    }

    public void setPriceExa(Double priceExa) {
        this.priceExa = priceExa;
    }

    public Double getPriceT1() {
        return priceT1;
    }

    public void setPriceT1(Double priceT1) {
        this.priceT1 = priceT1;
    }

    public Double getPriceInsurance() {
        return priceInsurance;
    }

    public void setPriceInsurance(Double priceInsurance) {
        this.priceInsurance = priceInsurance;
    }

    public Double getPriceRoadCharge() {
        return priceRoadCharge;
    }

    public void setPriceRoadCharge(Double priceRoadCharge) {
        this.priceRoadCharge = priceRoadCharge;
    }

    public Double getPriceOther() {
        return priceOther;
    }

    public void setPriceOther(Double priceOther) {
        this.priceOther = priceOther;
    }

    public Double getPriceVAT() {
        return priceVAT;
    }

    public void setPriceVAT(Double priceVAT) {
        this.priceVAT = priceVAT;
    }

    public Double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public ConsolidationStatus getStatus() {
        return status;
    }

    public void setStatus(ConsolidationStatus status) {
        this.status = status;
    }

    public Boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
    }

    public Boolean getCreateT1() {
        return createT1;
    }

    public void setCreateT1(Boolean createT1) {
        this.createT1 = createT1;
    }

    public Boolean getCreateExa() {
        return createExa;
    }

    public void setCreateExa(Boolean createExa) {
        this.createExa = createExa;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getLaddress() {
        return laddress;
    }

    public void setLaddress(String laddress) {
        this.laddress = laddress;
    }

    public String getFixTerm() {
        return fixTerm;
    }

    public void setFixTerm(String fixTerm) {
        this.fixTerm = fixTerm;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAss() {
        return ass;
    }

    public void setAss(String ass) {
        this.ass = ass;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getOrdernr() {
        return ordernr;
    }

    public void setOrdernr(String ordernr) {
        this.ordernr = ordernr;
    }

    public String getFixDate() {
        return fixDate;
    }

    public void setFixDate(String fixDate) {
        this.fixDate = fixDate;
    }

    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
    
    
    
            
    
}
