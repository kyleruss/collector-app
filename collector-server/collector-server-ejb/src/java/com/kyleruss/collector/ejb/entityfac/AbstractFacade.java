//=========================================
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//=========================================

package com.kyleruss.collector.ejb.entityfac;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractFacade<T>
{
    protected Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) 
    {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    
    public boolean verifyCreate(T entity)
    {
        create(entity);
        return getEntityManager().contains(entity);
    }
    
    public boolean verifyRemove(T entity)
    {
        remove(entity);
        return !getEntityManager().contains(entity);
    }

    public void create(T entity) 
    {
        getEntityManager().persist(entity);
        getEntityManager().flush();
    }

    public void edit(T entity)
    {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) 
    {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id)
    {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll()
    {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public int count() 
    {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public void refresh(T entity)
    {
        getEntityManager().refresh(entity);
    }
}
