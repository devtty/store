package org.devtty.store.util;

import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.FacesContext;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class FacesContextProducer {

    @Produces
    public FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }
    
}
