package org.devtty.store.view;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.devtty.store.entity.AbstractPersistable;

/**
 *
 * @author Denis Renning <denis@devtty.de>
 */
public abstract class AbstractPersistableSearchView<ENT extends AbstractPersistable> implements Serializable {
    
    @Inject EntityManager entityManager;
    
    protected Long resultCount;

    public Long getResultCount() {
        return resultCount;
    }

    public void setResultCount(Long resultCount) {
        this.resultCount = resultCount;
    }
    
    @PostConstruct
    public abstract void init();
    
    public void count(){
        CriteriaBuilder b = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = b.createQuery(Long.class);
        Root<ENT> root = countQuery.from((Class<ENT>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        countQuery.select(b.count(root));
        countQuery.where(b.and(getPredicates(b, root)));
        resultCount = entityManager.createQuery(countQuery).getSingleResult();
    }
    
    public Class<? extends ViewConfig> submit(){
        CriteriaBuilder b = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<ENT> q = b.createQuery(getEntityClass());
        Root<ENT> root = q.from(getEntityClass());
        q.where(b.and(getPredicates(b, root)));
        
        List<ENT> searchedFor = entityManager.createQuery(q).getResultList();
        
        AbstractPersistableIndexView v = CDI.current().select(getIndexView()).get();
        v.setAll(searchedFor);
        
        return getIndexPage();
    }
    
    private Class<ENT> getEntityClass(){
        return (Class<ENT>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    protected abstract Predicate[] getPredicates(CriteriaBuilder b, Root<ENT> root);
    
    protected abstract Class<? extends ViewConfig> getIndexPage();
    
    protected abstract Class<? extends AbstractPersistableIndexView> getIndexView();
    
    public enum NBoolean{
        NULL,
        YES,
        NO;
    }

}
