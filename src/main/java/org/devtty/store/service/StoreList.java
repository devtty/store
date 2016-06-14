package org.devtty.store.service;

import java.util.List;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.activiti.engine.TaskService;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class StoreList {

    @Inject
    private StoreRepository storeRepository;
    
    @Produces
    @Named("storeList")
    public List getStoreList(){
        return storeRepository.findAll();
    }
    
}
