package org.devtty.store.security;


import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.security.api.authorization.AbstractAccessDecisionVoter;
import org.apache.deltaspike.security.api.authorization.AccessDecisionVoterContext;
import org.apache.deltaspike.security.api.authorization.ErrorViewAwareAccessDeniedException;
import org.apache.deltaspike.security.api.authorization.SecurityViolation;
import org.devtty.store.security.Admin;
import org.slf4j.Logger;


/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@RequestScoped
public class RoleAccessDecisionVoter extends AbstractAccessDecisionVoter implements Serializable{
    
    @Inject HttpSession httpSession;
    @Inject Logger logger;
    
    @Override
    protected void checkPermission(AccessDecisionVoterContext advc, Set<SecurityViolation> violations){
        logger.info("checkPermission");
        HttpServletRequest request = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest());
        
        if(request.getAuthType()==null){
            logger.info("authtypenull");
            violations.add((SecurityViolation) () -> "not authenticated");
        }else{
            logger.info("AuthType not null");
            if(!viewAccessGranted(advc)){
                violations.add((SecurityViolation) () -> "view access denied, wrong role");
            }
        }
        
        if(advc.getMetaDataFor(Admin.class.getName(),Admin.class) != null && !FacesContext.getCurrentInstance().getExternalContext().isUserInRole("Admin")){
            violations.add((SecurityViolation) () -> "no sufficient permissions");
        }
        
        logger.info("chkViolations");
        if (!violations.isEmpty()) {
            logger.info("violations not empty");
            try {
                logger.info("try auth");
                ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).authenticate((HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse());
            } catch (IOException | ServletException ex) {
                logger.error(ex.getMessage());
            }
        }
    }

    private boolean viewAccessGranted(AccessDecisionVoterContext advc) {
        Class viewConfig = advc.getMetaDataFor(ViewConfig.class.getName(), Class.class);

        if(viewConfig.getAnnotations()==null){
            return true;            
        }
        
        for(Annotation a : viewConfig.getAnnotations()) {
            if((a instanceof Admin && FacesContext.getCurrentInstance().getExternalContext().isUserInRole("Admin"))){
                return true;
            }
        }
        return false;
    }
    
}
