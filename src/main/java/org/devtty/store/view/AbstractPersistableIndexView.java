package org.devtty.store.view;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.data.api.EntityRepository;
import org.devtty.store.entity.AbstractPersistable;

/**
 *
 * @author Denis Renning <denis@devtty.de>
 */
public abstract class AbstractPersistableIndexView<REPO extends EntityRepository<ENT, Long>, ENT extends AbstractPersistable> implements Serializable {

    private ENT detail;
    
    private List<ENT> all;
    
    private List<ENT> selected = new ArrayList<>();

    public ENT getDetail() {
        return detail;
    }

    public void setDetail(ENT detail) {
        this.detail = detail;
    }

    public List<ENT> getAll(){
        return all;
    }
    
    public void setAll(List<ENT> all){
        this.all = all;
    }
    
    public List<ENT> getSelected() {
        return selected;
    }

    public void setSelected(List<ENT> selected) {
        this.selected = selected;
    }
    
    @PostConstruct
    public void init(){
        REPO repo = BeanProvider.getContextualReference(getRepositoryClass());
        all = repo.findAll();
    }
    
    private Class<REPO> getRepositoryClass(){
        return (Class<REPO>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
    
    public boolean isPartial(){
        return (all != null) && BeanProvider.getContextualReference(getRepositoryClass()).count().intValue() - all.size() != 0;
    }
}
