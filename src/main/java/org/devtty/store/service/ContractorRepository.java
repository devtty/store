package org.devtty.store.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.Contractor;

/**
 *
 * @author Denis Renning
 */

@Repository(forEntity = Contractor.class)
public interface ContractorRepository extends EntityRepository<Contractor, Long> {
    
}
