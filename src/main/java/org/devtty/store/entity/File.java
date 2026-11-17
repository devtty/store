package org.devtty.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 *
 * @author Denis Renning
 */
@Entity
@Table(name = "ST_FILE")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_FILE")
public class File extends AbstractPersistable {
      
}
