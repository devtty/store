package org.devtty.store.converter;

import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import org.devtty.store.entity.Store;
import org.devtty.store.service.StoreRepository;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Named
@FacesConverter(forClass = Store.class)
public class StoreConverter extends AbstractPersistableConverter<StoreRepository, Store>{
}
