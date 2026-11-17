package org.devtty.store.service;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.devtty.store.entity.Item;

/**
 *
 * @author Denis Renning
 */

@Repository
public interface ItemRepository extends AbstractPersistableRepository<Item, Long> {
    
}
