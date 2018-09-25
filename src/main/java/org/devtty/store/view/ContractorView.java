package org.devtty.store.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Contractor;
import org.devtty.store.service.ContractorRepository;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Model
@WindowScoped
public class ContractorView extends AbstractPersistableIndexView<ContractorRepository, Contractor>{
    
    @Inject ContractorRepository contractorRepository;
    @Inject Logger logger;
    
    public Class<? extends ViewConfig> create(){
        setDetail(new Contractor());
        return Pages.Contractors.Edit.class;
    }

    public Class<? extends ViewConfig> edit(){
        setDetail(getSelected().get(0));
        return Pages.Contractors.Edit.class;
    }
}
