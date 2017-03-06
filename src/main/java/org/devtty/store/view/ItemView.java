package org.devtty.store.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Item;
import org.devtty.store.security.Admin;
import org.devtty.store.service.ItemRepository;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning
 */

@Model
@WindowScoped
//@Admin
public class ItemView extends AbstractPersistableIndexView<ItemRepository, Item>{
    
    @Inject ItemRepository itemRepository;
    @Inject Logger logger;
        
    public String save(){
        itemRepository.save((Item) getDetail());
        init();
        return "/items/index";
    }
    
    public String newItem(){
        setDetail(new Item());
        return "/items/edit";
    }
    
    public String editItem(){
        setDetail((Item) getSelected().get(0));
        return "/items/edit";
    }
    
    public String deleteItem(){
        // TODO implement
        init();
        return "/items/index";
    }

}
