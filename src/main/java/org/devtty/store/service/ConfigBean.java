package org.devtty.store.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.devtty.store.entity.Config;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@ApplicationScoped
public class ConfigBean {
    
    @Inject ConfigRepository configRepository;
    
    
    public String getValue(String str){
        Config c = configRepository.findBy(str);
        return c!=null ? c.getValue() : null;
    }
    
}
