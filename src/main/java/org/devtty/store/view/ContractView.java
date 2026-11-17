package org.devtty.store.view;

import jakarta.enterprise.inject.Model;
import jakarta.faces.lifecycle.ClientWindowScoped;
import jakarta.inject.Inject;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.devtty.store.entity.Contract;
import org.devtty.store.service.ContractRepository;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Model
@ClientWindowScoped
public class ContractView extends AbstractPersistableIndexView<ContractRepository, Contract>{
    
    @Inject ContractRepository contractRepository;
    @Inject Logger logger;
    
    public Class<? extends ViewConfig> create(){
        setDetail(new Contract());
        return Pages.Contracts.Edit.class;
    }
    
    public Class<? extends ViewConfig> edit(){
        setDetail(getSelected().get(0));
        return Pages.Contracts.Edit.class;
    }
            

}
