package org.devtty.store.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import org.devtty.store.entity.Store;
import org.devtty.store.service.StoreRepository;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Named
@FacesConverter(forClass = Store.class)
public class StoreConverter implements Converter {
    
    @Inject StoreRepository storeRepository;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String o) {
        if("".equals(o))
            return null;
        
        return storeRepository.findBy(Long.valueOf(o));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o == null)
            return "";
        
        return ((Store) o).getId().toString();
    }
    
    
    
}
