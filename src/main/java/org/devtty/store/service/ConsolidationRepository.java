package org.devtty.store.service;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.devtty.store.entity.Consolidation;

/**
 *
 * @author Denis Renning
 */

@Repository
public interface ConsolidationRepository extends AbstractPersistableRepository<Consolidation, Long> {
    
}
