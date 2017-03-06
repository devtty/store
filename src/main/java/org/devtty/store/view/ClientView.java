package org.devtty.store.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
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
    
    public String save(){
        clientRepository.save(getDetail());
        init();
        return "/clients/index";
    }
    
    public String newClient(){
        setDetail(new Client());
        return "/clients/edit";
    }
    
    public String editClient(){
        setDetail(getSelected().get(0));
        return "/clients/edit";
    }
    
    public String deleteClient(){
        // TODO implement
        init();
        return "/clients/index";
    }
    
}
