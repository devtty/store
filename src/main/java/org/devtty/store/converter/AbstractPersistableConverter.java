package org.devtty.store.converter;

import java.lang.reflect.ParameterizedType;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.data.api.EntityRepository;
import org.devtty.store.entity.AbstractPersistable;

public abstract class AbstractPersistableConverter<REPO extends EntityRepository<ENT, Long>, ENT extends AbstractPersistable> implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if("".equals(string))
            return null;
        
        REPO repo = BeanProvider.getContextualReference(getRepositoryClass());
        return repo.findBy(Long.valueOf(string));
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
