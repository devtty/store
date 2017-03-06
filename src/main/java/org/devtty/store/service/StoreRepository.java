package org.devtty.store.service;

import java.util.List;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.Store;

/**
 *
 * @author Denis Renning
 */

@Repository(forEntity = Store.class)
public interface StoreRepository extends EntityRepository<Store, Long> {
    
    public List<Store> findAllOrderByNameAsc();
    
}
