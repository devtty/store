package org.devtty.store.util;

import java.util.UUID;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletContext;
import org.apache.deltaspike.core.api.lifecycle.Initialized;
import org.devtty.store.entity.Config;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class Startup {
 
    @Inject 
    Logger logger;
    
    @PersistenceUnit(unitName = "storePU")
    private EntityManagerFactory emf;
    
    public void onCreate(@Observes @Initialized ServletContext context){
        logger.info("**** START UP STORE");
        
        EntityManager entityManager = emf.createEntityManager();
        
        //check if application has an id; if not create one
        Config c = entityManager.find(Config.class, "applicationId");
        if(c==null){
            c = new Config("applicationId", UUID.randomUUID().toString());
            entityManager.persist(c);
        }
        logger.info("New ApplicationID is: " + c.getValue());
        
        
        //count application starts
        c = entityManager.find(Config.class, "applicationStart");
        
        int starts = Integer.parseInt(c.getValue());
        c.setValue(Integer.toString(starts++));
        entityManager.persist(c);
        
        entityManager.close();

    }
    
}
