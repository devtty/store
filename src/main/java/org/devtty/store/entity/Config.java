package org.devtty.store.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Entity
@Table(name = "ST_CONFIG")
public class Config implements Serializable {
    
    @Id
    @Column(name = "CF_KEY")
    private String key;
    
    @Column(name = "CF_VAL")
    @NotNull
    private String value;

    public Config() {
    }

    public Config(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
