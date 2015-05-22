package org.devtty.store.service;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.inject.Inject;
import javax.inject.Named;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.Group;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.User;
import org.devtty.store.security.Admin;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning
 */
@Named
@WindowScoped
@Admin
public class UserView implements Serializable{
    
    @Inject UserRepository userRepository;
    @Inject ProcessEngine processEngine;
    @Inject Logger logger;
    
    private User user;
    
    private List<User> users;
    
    private List<User> selectedUsers;
    
    public List<Group> getActivitigroups(){
        return processEngine.getIdentityService().createNativeGroupQuery().list();
    }
 
    public List<ProcessDefinition> getProcesslist(){
        return processEngine.getRepositoryService().createProcessDefinitionQuery().list();
    }

    public List<Group> getUsergroups(){
        return processEngine.getIdentityService().createGroupQuery().groupType("assignment").list();
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

    public List<User> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<User> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public String save(){
        userRepository.save(user);
        logger.info("saved " + user);
        init();
        return "/users/index";
    }
    
    public String newUser(){
        this.user = new User();
        return "/users/edit";
    }
    
    public String editUser(){
        this.user = this.getSelectedUsers().get(0);
        return "/users/edit";
    }
    
    public void deleteUser(){
        for(User u : selectedUsers){
            logger.info("delete " + u.getLogin());
        }
        init();
    }
    
    @PostConstruct
    public void init(){
        users = userRepository.findAll();
        user = users.get(0);
    }
}
