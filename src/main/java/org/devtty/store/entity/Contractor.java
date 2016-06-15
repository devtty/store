package org.devtty.store.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Denis Renning
 */
@Entity
@Table(name = "ST_CONTRACTOR", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_CONTRACTOR")
public class Contractor extends AbstractPersistable {
    
    @NotNull
    private String name;

    @NotNull
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
