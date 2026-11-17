package org.devtty.store.service;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import java.util.List;
import org.devtty.store.entity.Store;

/**
 *
 * @author Denis Renning
 */

@Repository
public interface StoreRepository extends AbstractPersistableRepository<Store, Long> {
    
    public List<Store> findAllOrderByNameAsc();
    
}
