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
import org.primefaces.model.menu.DefaultSubMenu;
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
        
        DefaultMenuItem itemDashboard = new DefaultMenuItem(messages.menuDashboard());
        DefaultMenuItem itemClients = new DefaultMenuItem(messages.menuClients());
        //itemClients.setHref("/clients/");
        //itemClients.setOutcome("/clients");
        itemClients.setUrl("/clients/index.jsf");
        DefaultMenuItem itemCollections = new DefaultMenuItem(messages.menuCollections());
        itemCollections.setHref("/collections/");
        DefaultMenuItem itemConsolidations = new DefaultMenuItem(messages.menuConsolidations());
        itemConsolidations.setHref("/consolidations/");
        DefaultMenuItem itemContracts = new DefaultMenuItem(messages.menuContracts());
        itemContracts.setHref("/contracts/");
        DefaultMenuItem itemContractors = new DefaultMenuItem(messages.menuContractors());
        itemContractors.setHref("/contractors/");
        DefaultMenuItem itemItems = new DefaultMenuItem(messages.menuItems());
        itemItems.setHref("/items/");
        DefaultMenuItem itemStores = new DefaultMenuItem(messages.menuStores());
        itemStores.setHref("/stores/");
        DefaultMenuItem itemUsers = new DefaultMenuItem(messages.menuUsers(), "fa fa-user");
        //itemUsers.setHref("/users/index.jsf");
        itemUsers.setUrl("/users/index.jsf");
        
        model.addElement(itemDashboard);
        model.addElement(itemClients);
        model.addElement(itemCollections);
        model.addElement(itemConsolidations);
        model.addElement(itemContracts);
        model.addElement(itemContractors);
        model.addElement(itemItems);
        model.addElement(itemStores);
        model.addElement(itemUsers);
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
