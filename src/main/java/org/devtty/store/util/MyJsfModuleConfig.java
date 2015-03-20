package org.devtty.store.util;

import javax.enterprise.inject.Specializes;
import org.apache.deltaspike.jsf.api.config.JsfModuleConfig;
import org.apache.deltaspike.jsf.spi.scope.window.ClientWindowConfig;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Specializes
public class MyJsfModuleConfig extends JsfModuleConfig{
    
    @Override
    public ClientWindowConfig.ClientWindowRenderMode getDefaultWindowMode(){
        return ClientWindowConfig.ClientWindowRenderMode.CLIENTWINDOW;
    }
    
}
