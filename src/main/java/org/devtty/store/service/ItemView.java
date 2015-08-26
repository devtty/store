package org.devtty.store.service;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Item;
import org.devtty.store.security.Admin;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning
 */

@Named
@WindowScoped
@Admin
public class ItemView implements Serializable{
    
    @Inject ItemRepository itemRepository;
    @Inject Logger logger;
    
    private Item item;
    
    private List<Item> items;
    
    private List<Item> selectedItems;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Item> selectedItems) {
        this.selectedItems = selectedItems;
    }
    
    public String save(){
        itemRepository.save(item);
        init();
        return "/items/index";
    }
    
    public String newItem(){
        this.item = new Item();
        return "/items/edit";
    }
    
    public String editItem(){
        this.item = this.getSelectedItems().get(0);
        return "/items/edit";
    }
    
    public String deleteItem(){
        // TODO implement
        init();
        return "/items/index";
    }
    
    @PostConstruct
    public void init(){
        items = itemRepository.findAll();
        //item = items.get(0);
    }
}
