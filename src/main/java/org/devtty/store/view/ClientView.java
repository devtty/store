package org.devtty.store.view;

import jakarta.enterprise.inject.Model;
import jakarta.faces.lifecycle.ClientWindowScoped;
import jakarta.inject.Inject;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.devtty.store.entity.Client;
import org.devtty.store.service.ClientRepository;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning
 */

@Model
@ClientWindowScoped
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
