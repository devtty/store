package org.devtty.store.security;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Named
public class AuthenticationLinkView implements Serializable{
    
    @Inject
    private HttpSession httpSession;
       
    @Inject
    private Logger logger;
    
    private String title;
    
    private boolean loggedIn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    
    
    public String redirect() {
        logger.info("redirect" + loggedIn);
        try{
            if(loggedIn){
                ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).logout();
            }else{
                boolean x = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).authenticate((HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse());
                logger.info("authenti; " + x);
            }
        }catch(IOException | ServletException ex){
            logger.error(ex.getMessage());
        }
        
        return "/clients/index";
    }
    
    @PostConstruct
    public void init() {
        loggedIn = false;
        title = "Login";
        //if (httpSession != null && httpSession.getAttribute(KeycloakSecurityContext.class.getName()) != null) {
            loggedIn = true;
	    //    title =  ((KeycloakSecurityContext) httpSession.getAttribute(KeycloakSecurityContext.class.getName())).getToken().getEmail();

	    //}
    }
}
