package org.devtty.store.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.Consolidation;

/**
 *
 * @author Denis Renning
 */

@Repository(forEntity = Consolidation.class)
public interface ConsolidationRepository extends EntityRepository<Consolidation, Long> {
    
}
