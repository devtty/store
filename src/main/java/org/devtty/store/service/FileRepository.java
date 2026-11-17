package org.devtty.store.service;

import jakarta.data.repository.DataRepository;
import jakarta.data.repository.Repository;
import org.devtty.store.entity.File;

/**
 *
 * @author Denis Renning
 */

@Repository
public interface FileRepository extends DataRepository<File, Long> {
    
}
