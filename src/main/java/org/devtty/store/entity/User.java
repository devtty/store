package org.devtty.store.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.devtty.store.util.validation.Email;
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
 * 
 */
@Entity
@Table(name = "ST_USER", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_USER")
@Indexed
@AnalyzerDef(name = "useranalyzer",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
            @TokenFilterDef(factory = LowerCaseFilterFactory.class),
            @TokenFilterDef(factory = EdgeNGramFilterFactory.class, params = {
                @Parameter(name = "maxGramSize", value = "8"),
                @Parameter(name = "minGramSize", value = "3")}),})
@Analyzer(definition = "useranalyzer")
//@IdentityEntity(EntityType.IDENTITY_OBJECT)
public class User extends AbstractPersistable{
    
    @NotNull
    @Size(min = 5, max=60)
    @Field
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
