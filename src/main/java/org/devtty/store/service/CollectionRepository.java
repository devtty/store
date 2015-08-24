package org.devtty.store.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.Collection;

/**
 *
 * @author Denis Renning
 */

@Repository(forEntity = Collection.class)
public interface CollectionRepository extends EntityRepository<Collection, Long>{
    
}
