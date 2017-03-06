package org.devtty.store.service;

import java.util.List;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.Client;

/**
 *
 * @author Denis Renning
 */

@Repository(forEntity = Client.class)
public interface ClientRepository extends EntityRepository<Client, Long>{
    
    List<Client> findAllOrderByNameAsc();
    
}
