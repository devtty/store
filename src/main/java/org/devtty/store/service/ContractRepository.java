package org.devtty.store.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.Contract;

/**
 *
 * @author Denis Renning
 */

@Repository(forEntity = Contract.class)
public interface ContractRepository extends EntityRepository<Contract, Long> {
    
}
