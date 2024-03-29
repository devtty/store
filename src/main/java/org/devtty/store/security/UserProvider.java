package org.devtty.store.security;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.apache.deltaspike.data.api.audit.CurrentUser;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class UserProvider {

    @Inject HttpSession httpSession;
    
    @Produces @CurrentUser
    public String currentUser(){
        //return ((KeycloakSecurityContext) httpSession.getAttribute(KeycloakSecurityContext.class.getName())).getToken().getEmail();
	// replace w/ dummy for now
	return "denis@devtty.de";
    }
    
}
