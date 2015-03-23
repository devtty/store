package org.devtty.store.security;

import javax.enterprise.inject.spi.BeanManager;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.InvocationContext;

import org.apache.deltaspike.security.api.authorization.Secures;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class CustomAuthorizer {
    
    @Inject 
    private FacesContext facesContext;
    
    @Secures
    @Admin
    public boolean doSecuredCheck(InvocationContext invocationContext, BeanManager manager) throws Exception{
        return facesContext.getExternalContext().isUserInRole("Admin");
    }
    
}
