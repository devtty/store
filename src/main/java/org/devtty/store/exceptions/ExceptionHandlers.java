package org.devtty.store.exceptions;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.apache.deltaspike.security.api.authorization.ErrorViewAwareAccessDeniedException;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@ExceptionHandler
public class ExceptionHandlers {
    
    @Inject 
    private FacesContext facesContext;
    
    @Inject
    private ViewNavigationHandler view;
    
    @Inject
    private Logger logger;
    
    public void handleAccessDeniedException(@Handles ExceptionEvent<ErrorViewAwareAccessDeniedException> evt){

       logger.info("X1: " + evt.getException().getErrorView().getCanonicalName());
       logger.info("X2: " + evt.getException().getMessage());
     
        try{
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            if(!request.authenticate((HttpServletResponse) facesContext.getExternalContext().getResponse())){
                facesContext.responseComplete();
            }
            
            
        } catch(IOException | ServletException ex){
            logger.info("EX in AUTH");
        }   evt.handledAndContinue();
    }
    
}
