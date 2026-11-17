package org.devtty.store.service;

import java.util.List;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;

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
        return storeRepository.findAll().toList();
    }
    
}
