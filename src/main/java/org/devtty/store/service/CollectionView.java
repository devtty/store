package org.devtty.store.service;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Collection;
import org.devtty.store.security.Admin;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning
 */

@Named
@WindowScoped
@Admin
public class CollectionView implements Serializable{
    
    @Inject CollectionRepository collectionRepository;
    @Inject Logger logger;
    
    private Collection collection;
    
    private List<Collection> collections;
    
    private List<Collection> selectedCollection;

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    public List<Collection> getSelectedCollection() {
        return selectedCollection;
    }

    public void setSelectedCollection(List<Collection> selectedCollection) {
        this.selectedCollection = selectedCollection;
    }
    
    public String save(){
        collectionRepository.save(collection);
        return "/collections/index";
    }
    
    public String newCollection(){
        this.collection = new Collection();
        return "/collections/edit";
    }
    
    public String editCollection(){
        this.collection = this.getSelectedCollection().get(0);
        return "/collections/edit";
    }
    
    public String deleteCollection(){
        // TODO implement
        init();
        return "collections/index";
    }
    
    @PostConstruct
    public void init(){
        collections = collectionRepository.findAll();
        collection = collections.get(0);
    }
    
}
