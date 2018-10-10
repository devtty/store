package org.devtty.store.service;

import org.apache.deltaspike.data.api.Repository;
import org.devtty.store.entity.Holiday;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Repository(forEntity = Holiday.class)
public interface HolidayRepository {
    
}
