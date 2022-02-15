package org.devtty.store.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import org.devtty.store.MessageResources;

/**
 *
 * @author denis
 */
@Named
@SessionScoped
public class MenuView implements Serializable{
    
    @Inject MessageResources messages;
    
    @Getter @Setter private MenuModel model;
    
    @PostConstruct
    public void init(){
        
        model = new DefaultMenuModel();
        
        DefaultMenuItem itemDashboard = DefaultMenuItem.builder().value(messages.menuDashboard()).build();
        DefaultMenuItem itemClients = DefaultMenuItem.builder().value(messages.menuClients()).url("/clients/index.jsf").build();
        //itemClients.setHref("/clients/");
        //itemClients.setOutcome("/clients");
        
        DefaultMenuItem itemCollections = DefaultMenuItem.builder().value(messages.menuCollections()).url("/collections").build();
        DefaultMenuItem itemConsolidations = DefaultMenuItem.builder().value(messages.menuConsolidations()).url("/consolidations/").build();
        DefaultMenuItem itemContracts = DefaultMenuItem.builder().value(messages.menuContracts()).url("/contracts").build();
        DefaultMenuItem itemContractors = DefaultMenuItem.builder().value(messages.menuContractors()).url("/contractors/").build();
        DefaultMenuItem itemItems = DefaultMenuItem.builder().value(messages.menuItems()).url("/items/").build();
        DefaultMenuItem itemStores = DefaultMenuItem.builder().value(messages.menuStores()).url("/stores/").build();
        DefaultMenuItem itemUsers = DefaultMenuItem.builder().value(messages.menuUsers()).url("/users").icon("fa fa-user").build();
        
        model.getElements().add(itemDashboard);
        model.getElements().add(itemClients);
        model.getElements().add(itemCollections);
        model.getElements().add(itemConsolidations);
        model.getElements().add(itemContracts);
        model.getElements().add(itemContractors);
        model.getElements().add(itemItems);
        model.getElements().add(itemStores);
        model.getElements().add(itemUsers);
        /*DefaultSubMenu listSubmenu = new DefaultSubMenu(messages.menuLists(), "fa fa-list");
        DefaultSubMenu audienceSubmenu = new DefaultSubMenu(messages.menuAudience(), "fa fa-user");
        
        
        
        DefaultMenuItem listSearch = new DefaultMenuItem(messages.menuListsSearch(), "fa fa-search");
        DefaultMenuItem itemListList = new DefaultMenuItem(messages.menuListsLists());
        DefaultMenuItem itemAudienceFriend = new DefaultMenuItem(messages.menuAudienceFriends());
        DefaultMenuItem itemAudienceFollowers = new DefaultMenuItem(messages.menuAudienceFollowers());
        
        DefaultMenuItem itemAutomate = new DefaultMenuItem(messages.menuAutomate());
 
        itemListList.setHref("/lists/index.jsf");
        
        listSubmenu.addElement(listSearch);
        listSubmenu.addElement(itemListList);
        
        itemAudienceFollowers.setHref("/audience/followers.jsf");
        itemAudienceFriend.setHref("/audience/friends.jsf");
        
        audienceSubmenu.addElement(itemAudienceFollowers);
        audienceSubmenu.addElement(itemAudienceFriend);
        
        itemDashboard.setIcon("fa fa-home");
        
        itemAutomate.setIcon("fa fa-tasks");
        
        itemDashboard.setHref("/home.jsf");
        itemAutomate.setHref("/automate/index.jsf");
        
        model.addElement(itemDashboard);
        model.addElement(listSubmenu);
        model.addElement(audienceSubmenu);
        model.addElement(itemAutomate);*/
    }
    
}
