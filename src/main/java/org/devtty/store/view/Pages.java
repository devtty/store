package org.devtty.store.view;

import org.apache.deltaspike.core.api.config.view.DefaultErrorView;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.Folder;
import org.apache.deltaspike.jsf.api.config.view.View;

/**
 *
 * @author Denis Renning <denis@devtty.de>
 */
public interface Pages {

    @View(basePath = "/")
    class Index implements ViewConfig{}
    
    //@View(basePath = "/")
    //class Error extends DefaultErrorView{};
    
    @Folder(name = "/clients/")
    interface Clients{
        class Index implements ViewConfig{};
    }
    
    @Folder(name = "/items/")
    interface Items{
        class Index implements ViewConfig{}
    }
    
    @Folder(name = "/users/")
    interface Users{
        class Index implements ViewConfig{}
    }
    
}
