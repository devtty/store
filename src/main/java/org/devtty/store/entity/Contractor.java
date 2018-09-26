package org.devtty.store.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.devtty.store.util.validation.Email;

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
    
    @NotNull
    private String fax;
    
    private String contact;
    
    @Email
    private String email;
    
    private String phone;
            

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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
