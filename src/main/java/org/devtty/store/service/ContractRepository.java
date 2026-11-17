package org.devtty.store.service;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.devtty.store.entity.Contract;

/**
 *
 * @author Denis Renning
 */

@Repository
public interface ContractRepository extends AbstractPersistableRepository<Contract, Long> {
    
}
