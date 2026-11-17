
package org.devtty.store.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

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
