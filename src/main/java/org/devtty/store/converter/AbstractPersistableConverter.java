package org.devtty.store.converter;

import jakarta.data.repository.CrudRepository;
import jakarta.enterprise.inject.spi.CDI;
import java.lang.reflect.ParameterizedType;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import org.devtty.store.entity.AbstractPersistable;

public abstract class AbstractPersistableConverter<REPO extends CrudRepository<ENT, Long>, ENT extends AbstractPersistable> implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if("".equals(string))
            return null;
                
        REPO repo = CDI.current().select(getRepositoryClass()).get();
        return repo.findById(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o == null)
            return "";
        
        return ((ENT) o).getId().toString();
    }
    
    private Class<REPO> getRepositoryClass(){
        return (Class<REPO>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
    
    
    
}
