package org.devtty.store.util;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.apache.deltaspike.core.api.lifecycle.Initialized;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */

public class Startup {
 
    @Inject Logger logger;
    
    public void onCreate(@Observes @Initialized ServletContext context){
        logger.info("*** START UP STORE");
        
    }
    
}
