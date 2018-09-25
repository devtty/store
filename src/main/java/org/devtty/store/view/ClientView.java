package org.devtty.store.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Client;
import org.devtty.store.service.ClientRepository;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning
 */

@Model
@WindowScoped
//@Admin
public class ClientView extends AbstractPersistableIndexView<ClientRepository, Client>{
 
    @Inject ClientRepository clientRepository;
    @Inject Logger logger;
    
    public Class<? extends ViewConfig> save(){
        clientRepository.save(getDetail());
        init();
        return Pages.Clients.Index.class;
    }
    
    public Class<? extends ViewConfig> create(){
        setDetail(new Client());
        return Pages.Clients.Edit.class;
    }
    
    public Class<? extends ViewConfig> edit(){
        setDetail(getSelected().get(0));
        return Pages.Clients.Edit.class;
    }
    
    public String delete(){
        // TODO implement
        init();
        return "/clients/index";
    }
    
}
