package org.devtty.store.service;

import java.util.List;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class ProcessList {

    
    @Produces
    @Named("processList")
    public List getProcessList(){
        return null;
    }
    
}
