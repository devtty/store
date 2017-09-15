package org.devtty.store.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Data
@MappedSuperclass
public abstract class AbstractPersistable implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GEN")
    protected Long id;
    
}
