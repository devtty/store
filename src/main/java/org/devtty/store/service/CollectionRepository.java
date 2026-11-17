package org.devtty.store.service;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.devtty.store.entity.Collection;

/**
 *
 * @author Denis Renning
 */

@Repository
public interface CollectionRepository extends AbstractPersistableRepository<Collection, Long>{
    
}
