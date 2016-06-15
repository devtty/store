package org.devtty.store.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Denis Renning
 */
@Entity
@Table(name = "ST_FILE")
@SequenceGenerator(name = "SQ_GEN", sequenceName = "ST_SQ_FILE")
public class File extends AbstractPersistable {
      
}
