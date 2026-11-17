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
@Table(name = "ST_CLIENT")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_CLIENT")
@Indexed
public class Client extends AbstractPersistable{

    @OneToMany(mappedBy = "client")
    private List<Item> items;

    @NotNull
    @Size(min = 3, max = 255)
    @FullTextField
    private String name;

    @Size(max = 255)
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
