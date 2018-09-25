package org.devtty.store.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Store;
import org.devtty.store.service.StoreRepository;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Model
@WindowScoped
public class StoreView extends AbstractPersistableIndexView<StoreRepository, Store>{
    
    @Inject StoreRepository storeRepository;
    @Inject Logger logger;
    
    public Class<? extends ViewConfig> create(){
        setDetail(new Store());
        return Pages.Stores.Edit.class;
    }

    public Class<? extends ViewConfig> edit(){
        setDetail(getSelected().get(0));
        return Pages.Stores.Edit.class;
    }
}
