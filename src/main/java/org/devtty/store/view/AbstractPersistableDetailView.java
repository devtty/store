package org.devtty.store.view;

import java.io.Serializable;
import org.devtty.store.entity.AbstractPersistable;
import org.devtty.store.service.AbstractPersistableRepository;

/**
 *
 * @author Denis Renning <denis@devtty.de>
 */
public abstract class AbstractPersistableDetailView<REPO extends AbstractPersistableRepository<ENT, Long>, ENT extends AbstractPersistable> implements Serializable {

    
    
}
