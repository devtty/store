package org.devtty.store.service;

import jakarta.data.repository.CrudRepository;

/**
 *
 * @author denisrenning
 */
public interface AbstractPersistableRepository<AbstractPersistable, Long> extends CrudRepository<AbstractPersistable, Long> {
    
    int countAll();
    
}
