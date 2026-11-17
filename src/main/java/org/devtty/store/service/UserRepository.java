package org.devtty.store.service;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.devtty.store.entity.User;

/**
 *
 * @author Denis Renning
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}
