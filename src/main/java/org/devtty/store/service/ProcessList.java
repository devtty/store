package org.devtty.store.service;

import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.activiti.engine.RepositoryService;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class ProcessList {

    @Inject
    private RepositoryService repositoryService;
    
    @Produces
    @Named("processList")
    public List getProcessList(){
        return repositoryService.createProcessDefinitionQuery().list();
    }
    
}
