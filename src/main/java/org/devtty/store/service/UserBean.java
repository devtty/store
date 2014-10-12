package org.devtty.store.service;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.Group;
import org.activiti.engine.repository.ProcessDefinition;
import org.devtty.store.entity.User;

/**
 *
 * @author Denis Renning
 */
@Named
@RequestScoped
public class UserBean{
    
    @Inject UserRepository userRepository;
    @Inject ProcessEngine processEngine;
    
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<Group> getActivitigroups(){
        return processEngine.getIdentityService().createNativeGroupQuery().list();
    }
 
    public List<ProcessDefinition> getProcesslist(){
        return processEngine.getRepositoryService().createProcessDefinitionQuery().list();
    }

    public List<Group> getUsergroups(){
        return processEngine.getIdentityService().createGroupQuery().list();
    }
}
