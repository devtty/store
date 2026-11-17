package org.devtty.store.converter;

import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import org.devtty.store.entity.Client;
import org.devtty.store.service.ClientRepository;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Named
@FacesConverter(forClass = Client.class)
public class ClientConverter extends AbstractPersistableConverter<ClientRepository, Client>{
}
