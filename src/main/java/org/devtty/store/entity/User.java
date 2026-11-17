package org.devtty.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.devtty.store.util.validation.Email;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

/**
 *
 * @author Denis Renning
 * 
 */
@Entity
@Table(name = "ST_USER", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_USER")
//@IdentityEntity(EntityType.IDENTITY_OBJECT)
@Indexed
public class User extends AbstractPersistable{
    
    @NotNull
    @Size(min = 5, max=60)
    @FullTextField
    private String name;
    
    @NotNull
    @Size(min = 6, max=25)
    private String login;
    
    @NotNull
    @Size(min = 8, max=32)
    private String pass;
    
    @NotNull
    @Email
    private String email;
    
    private String role;
    
    private boolean accounting;
    
    @ManyToOne
    private Store store;
    
    @ManyToOne
    private Client client;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAccounting() {
        return accounting;
    }

    public void setAccounting(boolean accounting) {
        this.accounting = accounting;
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

}
