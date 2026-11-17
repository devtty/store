package org.devtty.store.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

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
    @FullTextField
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
