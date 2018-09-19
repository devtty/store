package org.devtty.store;

import org.apache.deltaspike.core.api.message.MessageBundle;
import org.apache.deltaspike.core.api.message.MessageTemplate;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@MessageBundle
public interface MessageResources {

    @MessageTemplate("{nav.dashboard}")
    String menuDashboard();

    @MessageTemplate("{nav.clients}")
    String menuClients();

    @MessageTemplate("{nav.collections}")
    String menuCollections();

    @MessageTemplate("{nav.consolidations}")
    String menuConsolidations();

    @MessageTemplate("{nav.contracts}")
    String menuContracts();

    @MessageTemplate("{nav.contractors}")
    String menuContractors();

    @MessageTemplate("{nav.items}")
    String menuItems();

    @MessageTemplate("{nav.stores}")
    String menuStores();

    @MessageTemplate("{nav.users}")
    String menuUsers();

}
