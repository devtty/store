package org.devtty.store.view;

import java.io.Serializable;
import org.apache.deltaspike.data.api.EntityRepository;
import org.devtty.store.entity.AbstractPersistable;

/**
 *
 * @author Denis Renning <denis@devtty.de>
 */
public abstract class AbstractPersistableDetailView<REPO extends EntityRepository<ENT, Long>, ENT extends AbstractPersistable> implements Serializable {

    
    
}
