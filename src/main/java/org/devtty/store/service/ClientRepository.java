package org.devtty.store.service;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import java.util.List;
import org.devtty.store.entity.Client;

/**
 *
 * @author Denis Renning
 */

@Repository
public interface ClientRepository extends AbstractPersistableRepository<Client, Long>{
    
    List<Client> findAllOrderByNameAsc();
    
}
