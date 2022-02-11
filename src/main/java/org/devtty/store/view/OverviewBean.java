package org.devtty.store.view;

import java.security.Principal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
