package org.devtty.store.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Denis Renning
 */
@Entity
@Table(name = "ST_STORE")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_STORE")
@Indexed
public class Store extends AbstractPersistable{
    
    @OneToMany(mappedBy = "store")
    private List<Item> items;

    @NotNull
    @Size(min = 3, max = 64)
    @Field
    private String name;
    
    @Size(max = 250)
    private String address;

    private String zipCode;
    
    private String iso3166;
    
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getIso3166() {
        return iso3166;
    }

    public void setIso3166(String iso3166) {
        this.iso3166 = iso3166;
    }
    
    

}
