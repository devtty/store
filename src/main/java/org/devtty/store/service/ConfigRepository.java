package org.devtty.store.service;

import jakarta.data.repository.DataRepository;
import jakarta.data.repository.Repository;
import org.devtty.store.entity.Config;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Repository
public interface ConfigRepository extends DataRepository<Config, String>{
    
    Config findByKey(String key);
    
}
