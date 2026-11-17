package org.devtty.store.view;

import java.security.Principal;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author DenisRenning
 */
@Named
@RequestScoped
public class OverviewBean {
    
    @Resource Principal principal;
    
    @PostConstruct
    public void init(){
        
    }

}
