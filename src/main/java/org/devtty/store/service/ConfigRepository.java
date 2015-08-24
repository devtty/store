package org.devtty.store.service;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.Config;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Repository(forEntity = Config.class)
public interface ConfigRepository extends EntityRepository<Config, String>{
    
    
    
}
