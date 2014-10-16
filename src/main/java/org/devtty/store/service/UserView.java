package org.devtty.store.service;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
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
@ViewScoped
public class UserView implements Serializable{
    
    @Inject UserRepository userRepository;
    @Inject ProcessEngine processEngine;
    
    private User user;
    
    private List<User> users;
    
    public List<Group> getActivitigroups(){
        return processEngine.getIdentityService().createNativeGroupQuery().list();
    }
 
    public List<ProcessDefinition> getProcesslist(){
        return processEngine.getRepositoryService().createProcessDefinitionQuery().list();
    }

    public List<Group> getUsergroups(){
        return processEngine.getIdentityService().createGroupQuery().list();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    @PostConstruct
    public void init(){
        users = userRepository.findAll();
        user = users.get(0);
    }
}
