package org.devtty.store.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Contract;
import org.devtty.store.service.ContractRepository;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Model
@WindowScoped
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
