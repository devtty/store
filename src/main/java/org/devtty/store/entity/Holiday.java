
package org.devtty.store.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Denis Renning
 */

@Entity
@Table(name = "ST_HOLIDAY")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_HOLIDAY")
public class Holiday extends AbstractPersistable{
    
    @NotNull
    private String name;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date day;
    
    @ManyToOne
    private Store store;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
