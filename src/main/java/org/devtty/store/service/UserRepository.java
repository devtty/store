package org.devtty.store.service;

import javax.enterprise.context.Dependent;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.User;

/**
 *
 * @author Denis Renning
 */
@Repository(forEntity = User.class)
public interface UserRepository extends EntityRepository<User, Long>{
    
    
    
}
