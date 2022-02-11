package org.devtty.store.view;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Item;
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
    
    public Class<? extends ViewConfig> create(){
        setDetail(new Item());
        return Pages.Items.Edit.class;
    }
    
    public Class<? extends ViewConfig> edit(){
        setDetail((Item) getSelected().get(0));
        return Pages.Items.Edit.class;
    }
    
    public String delete(){
        // TODO implement
        init();
        return "/items/index";
    }

    
    public int getSumKolli(){
        return getAll().stream().mapToInt(o -> o.getKolli()).sum();
    }
    
    public int getSumStoreUnit(){
        return getAll().stream().mapToInt(o -> o.getStoreUnit()).sum();
    }
    
}
