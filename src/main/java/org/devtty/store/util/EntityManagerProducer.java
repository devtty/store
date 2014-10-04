package org.devtty.store.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Denis Renning
 */
public class EntityManagerProducer {
    
    @PersistenceUnit(unitName = "storePU")
    private EntityManagerFactory entityManagerFactory;
    
    @Produces
    @Default
    @RequestScoped
    public EntityManager create(){
        return this.entityManagerFactory.createEntityManager();
    }
    
    public void dispose(@Disposes @Default EntityManager entityManager){
        if(entityManager.isOpen()){
            entityManager.close();
        }
    }
}
