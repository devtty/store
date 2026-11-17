package org.devtty.store.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.devtty.store.entity.Config;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@ApplicationScoped
public class ConfigBean {
    
    @Inject ConfigRepository configRepository;
    
    
    public String getValue(String str){
        Config c = configRepository.findByKey(str);
        return c!=null ? c.getValue() : null;
    }
    
}
