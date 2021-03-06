package org.devtty.store.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.apache.lucene.search.Query;
import org.devtty.store.entity.Client;
import org.devtty.store.entity.Item;
import org.devtty.store.entity.User;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
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
    
    @Transactional(readOnly = true)
    public List<SearchResult> complete(String query){
        List<SearchResult> s = new ArrayList<>();
      
        logger.debug("SEARCH LUCENE %s", query);
        
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        
        QueryBuilder builder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Client.class).get();
        
        Query q = builder.keyword().onField("name").matching(query).createQuery();
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(q, Client.class);
        
        List result = jpaQuery.getResultList();
        logger.debug("result: %s", result.size());
        
        for(Object u : result){
            s.add(new SearchResult((Client) u));
        }
        
        builder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();
        q = builder.keyword().onField("name").matching(query).createQuery();
        jpaQuery = fullTextEntityManager.createFullTextQuery(q, User.class);
        result = jpaQuery.getResultList();
        
        for(Object u : result){
            s.add(new SearchResult((User) u));
        }
        
        builder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Item.class).get();
        q = builder.keyword().onField("name").matching(query).createQuery();
        jpaQuery = fullTextEntityManager.createFullTextQuery(q, Item.class);
        result = jpaQuery.getResultList();
        for(Object i : result){
            s.add(new SearchResult((Item) i));
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
