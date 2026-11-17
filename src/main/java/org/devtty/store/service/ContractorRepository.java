package org.devtty.store.service;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.devtty.store.entity.Contractor;

/**
 *
 * @author Denis Renning
 */

@Repository
public interface ContractorRepository extends AbstractPersistableRepository<Contractor, Long> {
    
}
