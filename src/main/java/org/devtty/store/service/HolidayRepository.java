package org.devtty.store.service;

import jakarta.data.repository.DataRepository;
import jakarta.data.repository.Repository;
import org.devtty.store.entity.Holiday;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Repository
public interface HolidayRepository extends DataRepository<Holiday, Long> {
    
}
