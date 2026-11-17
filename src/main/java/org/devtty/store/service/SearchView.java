package org.devtty.store.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.apache.lucene.search.Query;
import org.devtty.store.entity.Client;
import org.devtty.store.entity.Item;
import org.devtty.store.entity.User;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;


/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Named
public class SearchView implements Serializable{

    @Inject
    private EntityManager entityManager;
    
    @Inject
    private FacesContext facesContext;
    
    @Inject
    private UserView userView;
    
    @Inject
    SearchSession searchSession;
    
    @Inject
    private Logger logger;

    private SearchResult term;
    
    public SearchResult getTerm() {
        return term;
    }

    public void setTerm(SearchResult term) {
        this.term = term;
    }
    
    @PostConstruct
    public void init(){
    }
    
    @Transactional
    public List<SearchResult> complete(String query){
        List<SearchResult> s = new ArrayList<>();
      
        logger.debug("SEARCH LUCENE %s", query);
        
        org.hibernate.search.engine.search.query.SearchResult<Client> fetchAllSearchResult = searchSession.search(Client.class).where(q -> q.simpleQueryString().field("name").matching(query)).fetchAll();
        List<Client> hits = fetchAllSearchResult.hits();
        
        logger.debug("hits: %s", hits.size());
        
       
        for(Client c : hits){
            s.add(new SearchResult(c));
        }
        
        org.hibernate.search.engine.search.query.SearchResult<User> fetchAllUsers = searchSession.search(User.class).where(q -> q.simpleQueryString().field("name").matching(query)).fetchAll();
        List<User> userList = fetchAllUsers.hits();
        
        for(User u : userList){
            s.add(new SearchResult(u));
        }
        
        org.hibernate.search.engine.search.query.SearchResult<Item> fetchAllItems = searchSession.search(Item.class).where(q -> q.simpleQueryString().field("name").matching(query)).fetchAll();
        List<Item> itemList = fetchAllItems.hits();
        
        for(Item i : itemList){
            s.add(new SearchResult(i));
        }
        
        return s;
    }
    
    public void onItemSelect(SelectEvent event){
        SearchResult result = (SearchResult) event.getObject();
        
        switch(result.getType()){
            
            case SearchResult.SR_USER :  {
            try {
                userView.setUser((User) result.getValue());
                // TODO remove hardcoded ctx
                facesContext.getExternalContext().redirect("/store/users/edit.jsf");
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        }
                
        }
        
    }
}
