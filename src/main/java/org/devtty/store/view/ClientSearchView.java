package org.devtty.store.view;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.devtty.store.entity.Client;
import org.devtty.store.entity.Client_;
import org.devtty.store.service.ClientRepository;

/**
 *
 * @author Denis Renning <denis@devtty.de>
 */
@Named
@ViewAccessScoped
public class ClientSearchView extends AbstractPersistableSearchView<Client>{
    
    @Inject ClientRepository clientRepository;
    
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    
    @PostConstruct
    public void init() {
        count();
    }

    @Override
    protected Predicate[] getPredicates(CriteriaBuilder b, Root<Client> client) {
        List<Predicate> prdcts = new ArrayList<>();
        if(name != null && !name.isEmpty()){
            prdcts.add(b.like(client.get(Client_.name), "%" + name + "%"));
        }
        if(address != null && !address.isEmpty()){
            prdcts.add(b.like(client.get(Client_.address), "%" + address + "%"));
        }
            
        
        return prdcts.toArray(new Predicate[prdcts.size()]);
    }

    @Override
    protected Class<? extends ViewConfig> getIndexPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Class<? extends AbstractPersistableIndexView> getIndexView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
