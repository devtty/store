package org.devtty.store.service;

import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

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
