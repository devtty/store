package org.devtty.store.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.Item;

/**
 *
 * @author Denis Renning
 */

@Repository(forEntity = Item.class)
public interface ItemRepository extends EntityRepository<Item, Long> {
    
}
