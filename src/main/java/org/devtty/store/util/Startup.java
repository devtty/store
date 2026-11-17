package org.devtty.store.util;

import java.util.UUID;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.apache.commons.lang3.RandomStringUtils;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.devtty.store.entity.Config;
import org.devtty.store.entity.User;
import org.slf4j.Logger;

/**
 * @author Denis Renning <denis at devtty.de>
 */
@Singleton
@jakarta.ejb.Startup
public class Startup {
 
    @Inject 
    Logger logger;
    
    @Inject 
    ProjectStage projectStage;
    
    @Inject
    EntityManager entityManager;    
    
    @PostConstruct
    public void init() {
        logger.info("*** START UP STORE");
        
        //check if application has an id; if not create one
        Config c = entityManager.find(Config.class, "applicationId");
        if(c==null){
            c = new Config("applicationId", UUID.randomUUID().toString());
            entityManager.persist(c);
        }
        logger.info("New ApplicationID is: %s", c.getValue());
        
        
        //count application starts
        c = entityManager.find(Config.class, "applicationStart");
        
        logger.info("C: %s", c);
        
        int starts = 0;
        
        if(c != null){
            starts =  Integer.parseInt(c.getValue());
        }else{
            c = new Config("applicationStart", "0");
        }
        
        c.setValue(Integer.toString(starts++));
        entityManager.persist(c);
      
        //just for dev TODO remove later (incl. method)
        if(ProjectStage.Development.equals(this.projectStage)){
            addSomeUsers();
        }
        
        //createIndizies();
        entityManager.close();
    }
    
    /*
    public void createIndizies(){
        try {
            logger.info("Build Index");
            FullTextEntityManager fulltextEntityManager = Search.getFullTextEntityManager(entityManager);
            fulltextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException ex) {
            logger.error("Error while indexing");
        }
        
    }
*/
    private void addSomeUsers() {
        logger.debug("addSomeUsers");
        for(int i = 0; i < 300; i++){
            User u = new User();
            u.setLogin(RandomStringUtils.randomAlphabetic(8));
            u.setName(RandomStringUtils.randomAlphabetic(8));
            u.setPass(RandomStringUtils.randomAlphabetic(8));
            u.setEmail(RandomStringUtils.randomAlphanumeric(4) + "@devtty.de");
            u.setRole("user");
            entityManager.persist(u);
        }
        
        entityManager.flush();
    }
}
