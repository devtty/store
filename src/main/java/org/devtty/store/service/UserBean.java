package org.devtty.store.service;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.devtty.store.entity.User;

/**
 *
 * @author Denis Renning
 */
@Named
@RequestScoped
public class UserBean{
    
    @Inject UserRepository userRepository;
    
    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
