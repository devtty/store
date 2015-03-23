package org.devtty.store.util;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

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
