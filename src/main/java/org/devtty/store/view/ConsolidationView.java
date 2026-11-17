package org.devtty.store.view;

import jakarta.enterprise.inject.Model;
import jakarta.faces.lifecycle.ClientWindowScoped;
import jakarta.inject.Inject;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.devtty.store.entity.Consolidation;
import org.devtty.store.service.ConsolidationRepository;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Model
@ClientWindowScoped
public class ConsolidationView extends AbstractPersistableIndexView<ConsolidationRepository, Consolidation>{
    
    @Inject ConsolidationRepository consolidationRepository;
    @Inject Logger logger;
    

    public Class<? extends ViewConfig> create(){
        setDetail(new Consolidation());
        return Pages.Consolidations.Edit.class;
    }

    public Class<? extends ViewConfig> edit(){
        setDetail(getSelected().get(0));
        return Pages.Consolidations.Edit.class;
    }
}
