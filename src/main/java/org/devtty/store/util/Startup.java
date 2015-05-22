package org.devtty.store.util;

import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.devtty.store.entity.Config;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.slf4j.Logger;

/**
 * @author Denis Renning <denis at devtty.de>
 */
@Singleton
@javax.ejb.Startup
public class Startup {
 
    @Inject 
    Logger logger;
    
    @Inject
    EntityManager entityManager;
    
    @Inject
    IdentityService identityService;
    
    
    @PostConstruct
    public void init() {
        logger.info("*** START UP STORE");
        
        //check if application has an id; if not create one
        Config c = entityManager.find(Config.class, "applicationId");
        if(c==null){
            c = new Config("applicationId", UUID.randomUUID().toString());
            entityManager.persist(c);
        }
        logger.info("New ApplicationID is: " + c.getValue());
        
        
        //count application starts
        c = entityManager.find(Config.class, "applicationStart");
        
        logger.info("C: " + c);
        
        int starts = 0;
        
        if(c != null){
            starts =  Integer.parseInt(c.getValue());
        }else{
            c = new Config("applicationStart", "0");
        }
        
        c.setValue(Integer.toString(starts++));
        entityManager.persist(c);
        
        
        //check activiti
        logger.info("A");
        List<Group> groups = identityService.createGroupQuery().list();
        for(Group group : groups){
            logger.info("Group: " + group.getName() + "(" + group.getType() + ")");
        }
        if(identityService.createGroupQuery().groupId("storage").list().size() == 0){
            logger.info("Group storage not found ... created");
            Group g = identityService.newGroup("storage");
            g.setType("assignment");
            g.setName("Storage");
            identityService.saveGroup(g);
        }

        logger.info("B");
        
        createIndizies();entityManager.close();
    }
    
    
    public void createIndizies(){
        try {
            logger.info("Build Index");
            FullTextEntityManager fulltextEntityManager = Search.getFullTextEntityManager(entityManager);
            fulltextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException ex) {
            logger.error("Error while indexing");
        }
        
    }
}
