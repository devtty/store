package org.devtty.store.service;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Client;
import org.devtty.store.security.Admin;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning
 */

@Named
@WindowScoped
@Admin
public class ClientView implements Serializable{
 
    @Inject ClientRepository clientRepository;
    @Inject Logger logger;
    
    private Client client;
    
    private List<Client> clients;
    
    private List<Client> selectedClients;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getSelectedClients() {
        return selectedClients;
    }

    public void setSelectedClients(List<Client> selectedClients) {
        this.selectedClients = selectedClients;
    }
    
    public String save(){
        clientRepository.save(client);
        init();
        return "/clients/index";
    }
    
    public String newClient(){
        this.client = new Client();
        return "/clients/edit";
    }
    
    public String editClient(){
        this.client = this.getSelectedClients().get(0);
        return "/clients/edit";
    }
    
    public String deleteClient(){
        // TODO implement
        init();
        return "/clients/index";
    }
    
    @PostConstruct
    public void init(){
        clients = clientRepository.findAll();
        client = clients.get(0);
    }
    
}
