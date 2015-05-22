package org.devtty.store.service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.devtty.store.entity.Client;


/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@FacesConverter("searchResultConverter")
public class SearchResultConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null){
            if(o instanceof Client){
                return ((Client) o).getName();
            }
        }
        return null;
    }
    
}
