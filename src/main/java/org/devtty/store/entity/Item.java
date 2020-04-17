package org.devtty.store.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.deltaspike.data.api.audit.CreatedOn;
import org.apache.deltaspike.data.api.audit.ModifiedOn;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.envers.Audited;
import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

/**
 *
 * @author Denis Renning
 */
@Entity
@Table(name = "ST_ITEM")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_ITEM")
@Audited(targetAuditMode = NOT_AUDITED)
@Indexed
@AnalyzerDef(name = "itemanalyzer",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
            @TokenFilterDef(factory = LowerCaseFilterFactory.class),
            @TokenFilterDef(factory = EdgeNGramFilterFactory.class, params = {
                @Parameter(name = "maxGramSize", value = "8"),
                @Parameter(name = "minGramSize", value = "3")}),})
public class Item extends AbstractPersistable{
    
    @Size(max = 20)
    private String clientRef;
    private String consolidate;
    private String startlocation;
    private String startcorporation;
    
    @NotNull
    @Field
    @Analyzer(definition = "itemanalyzer")
    private String name;
    private String inMProblem;
    private String docs;
    private String bvdInfo;
    private String vehicleNo;
    
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Temporal(TemporalType.DATE)
    private Date indate;
    @Temporal(TemporalType.DATE)
    private Date outDate;
    @Temporal(TemporalType.DATE)
    private Date customsIn;
    
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedOn
    private Date created;
    
    @Temporal(TemporalType.TIMESTAMP)
    @ModifiedOn
    private Date updated;
    
    @NotNull
    @Min(value = 0)
    private Integer kolli;
    private Integer paletten;
    private Integer storeUnit;
    
    
    private Double inW;
    private Double inV;
    private Double currentWeight;
    
    private BigDecimal key;
    private BigDecimal lid;
    private BigDecimal splitId;
    
    private boolean inMOk;
    private boolean inWOk;
    private boolean currentWeightOk;
    private boolean t1;
    private boolean adr;
    private boolean ex;
    
    @Enumerated(EnumType.STRING)
    private ItemStatus status;
    
    @ManyToOne
    private Collection collection;
    
    @ManyToOne
    private Store store;
    
    @ManyToOne
    private Client client;
    
    @ManyToOne
    private User lastChangeBy;
            
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

    public Integer getStoreUnit() {
        return storeUnit;
    }

    public void setStoreUnit(Integer storeUnit) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}
