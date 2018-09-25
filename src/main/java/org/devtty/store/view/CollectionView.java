package org.devtty.store.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Collection;
import org.devtty.store.service.CollectionRepository;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Model
@WindowScoped
public class CollectionView extends AbstractPersistableIndexView<CollectionRepository, Collection>{
    
    @Inject CollectionRepository collectionRepository;
    @Inject Logger logger;
    
    public Class<? extends ViewConfig> create(){
        setDetail(new Collection());
        return Pages.Collections.Edit.class;
    }
    
    public Class<? extends ViewConfig> edit(){
        setDetail((Collection) getSelected().get(0));
        return Pages.Collections.Edit.class;
    }

}
