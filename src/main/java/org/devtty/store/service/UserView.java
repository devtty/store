package org.devtty.store.service;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.User;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning
 */
@Named
@WindowScoped
public class UserView implements Serializable{
    
    @Inject UserRepository userRepository;
    
    @Inject Logger logger;
    
    private User user;
    
    private List<User> users;
    
    private List<User> selectedUsers;
        
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
        logger.info("saved %s", user);
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
            logger.info("delete %s", u.getLogin());
        }
        init();
    }
    
    @PostConstruct
    public void init(){
        users = userRepository.findAll();
        user = users.get(0);
    }
}
