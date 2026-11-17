package org.devtty.store.view;

import org.devtty.store.service.AbstractPersistableRepository;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.spi.CDI;
import org.devtty.store.entity.AbstractPersistable;

/**
 *
 * @author Denis Renning <denis@devtty.de>
 */
public abstract class AbstractPersistableIndexView<REPO extends AbstractPersistableRepository<ENT, Long>, ENT extends AbstractPersistable> implements Serializable {

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
        all = CDI.current().select(getRepositoryClass()).get().findAll().toList();
    }
    
    private Class<REPO> getRepositoryClass(){
        return (Class<REPO>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
    
    public boolean isPartial(){
        return (all != null) && CDI.current().select(getRepositoryClass()).get().countAll() - all.size() != 0;
    }
}
