package org.devtty.store.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.File;

/**
 *
 * @author Denis Renning
 */

@Repository(forEntity = File.class)
public interface FileRepository extends EntityRepository<File, Long> {
    
}
