package com.free4lab.filesystem.sql.dao;

/**
 * Created by KillOver on 2016/9/21.
 */

import com.free4lab.filesystem.sql.helper.IEntityManagerHelper;
import org.hibernate.FlushMode;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDAO<T> {

   public String getClassName() {
        return getEntityClass().getName();
    }

   public abstract Class getEntityClass();

   public abstract String getPUName();

   public abstract IEntityManagerHelper getEntityManagerHelper();

    protected EntityManager getEntityManager() {
        return getEntityManagerHelper().getEntityManager(getPUName());
    }
    protected Logger logger = null;

    protected Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(getClassName());
        }
        return logger;
    }

    protected void log(String info, Level level, Throwable ex) {
        getLogger().log(level, info, ex);
    }

    public void save(Collection<T> el) {

        EntityManager em = getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
        em.getTransaction().begin();

        log("saving " + getClassName() + " instance", Level.INFO, null);
        try {
            Session session = (Session) em.getDelegate();
            session.setFlushMode(FlushMode.MANUAL);

            for (T entity : el) {
                session.save(entity);
            }
            session.flush();
            session.clear();

            log("save successful", Level.INFO, null);
            em.getTransaction().commit();
        } catch (RuntimeException re) {
            log("save failed", Level.SEVERE, re);
            em.getTransaction().rollback();
            throw re;
        }

    }

    @SuppressWarnings("unchecked")
    public void save(T entity) {

        EntityManager em = getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
        em.getTransaction().begin();

        log("saving " + getClassName() + " instance", Level.INFO, null);
        try {
            em.persist(entity);
            log("save successful", Level.INFO, null);
            em.getTransaction().commit();
        } catch (RuntimeException re) {
            log("save failed", Level.SEVERE, re);
            em.getTransaction().rollback();
            throw re;
        }

    }

    @SuppressWarnings("unchecked")
    public void deleteByPrimaryKey(Object primaryKey) {

        EntityManager em = getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
        em.getTransaction().begin();
        log("deleting " + getClassName() + " instance", Level.INFO, null);
        try {
            Object entity = em.getReference(getEntityClass(),
                    primaryKey);
            em.remove(entity);
            log("delete successful", Level.INFO, null);
            em.getTransaction().commit();
        } catch (RuntimeException re) {
            log("delete failed", Level.SEVERE, re);
            em.getTransaction().rollback();
            throw re;
        }
    }


    @SuppressWarnings("unchecked")
    public void update(Collection<T> el) {

        EntityManager em = getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
        em.getTransaction().begin();

        log("updating " + getClassName() + " instance", Level.INFO, null);
        try {
            for (T entity : el) {
                em.merge(entity);
            }
            log("update successful", Level.INFO, null);
            em.getTransaction().commit();
        } catch (RuntimeException re) {
            log("update failed", Level.SEVERE, re);
            em.getTransaction().rollback();
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public T update(T entity) {

        EntityManager em = getEntityManager();

        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            log("A transaction is still active before another begin, we have to roll back it!", Level.SEVERE, null);
        }
        em.getTransaction().begin();

        log("updating " + getClassName() + " instance", Level.INFO, null);
        try {
            T result = em.merge(entity);
            log("update successful", Level.INFO, null);
            em.getTransaction().commit();
            return result;
        } catch (RuntimeException re) {
            log("update failed", Level.SEVERE, re);
            em.getTransaction().rollback();
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public T findByPrimaryKey(Object pKey) {
        log("finding " + getClassName() + " instance with primary key: " + pKey,
                Level.INFO, null);
        try {
            Object instance = getEntityManager().find(getEntityClass(), pKey);
            return (T) instance;
        } catch (RuntimeException re) {
            log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

     @SuppressWarnings("unchecked")
    public T findById(Integer id) {
        return findByPrimaryKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findByProperty(String propertyName,
                                  final Object value) {
        log("finding " + getClassName() + " instance with property: "
                + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from " + getClassName() + " model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find by property name failed",
                    Level.SEVERE, re);
            throw re;
        }
    }

     @SuppressWarnings("unchecked")
    public List<T> findByProperty2(String name1,
                                   final Object value1,String name2,final Object value2) {
        log("finding " + getClassName() + " instance with property1: "
                + name1 + ", value1: " + value1
                + "; propety2: "+ name2 + ", value2: " + value2, Level.INFO, null);
        try {
            final String queryString = "select model from " + getClassName() + " model where model."
                    + name1 + "= :value1 and model." + name2 + "= :value2";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("value1", value1);
            query.setParameter("value2", value2);
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find by property name2 failed",
                    Level.SEVERE, re);
            throw re;
        }
    }
    @SuppressWarnings("unchecked")
    public List<T> findByProperty(Map<String, Object> params,Map<String, List<Object>> paramslist,
                                  Integer page,Integer size,String nameorder,boolean order) {
        try {
            String queryString = "select model from " + getClassName() + " model";
            int top = 1;
            if (null != paramslist && paramslist.size()>0)
                for(Map.Entry<String,List<Object>> entry : paramslist.entrySet())
                {
                    if(entry.getValue().size()>0)
                    {
                        if (1 == top)
                            queryString += " where";
                        else
                            queryString += " and";
                        queryString += " model."+entry.getKey()+" ";

                        for(int i=0;i<entry.getValue().size();i++)
                        {
                            if(i==0)
                                queryString += "in (";
                            else
                                queryString += ",";
                            queryString += "'"+entry.getValue().get(i)+"'";
                            if(i+1==entry.getValue().size())
                                queryString += ")";
                        }
                        top++;
                    }
                }
            if (null != params && params.size()>0)
                for(Map.Entry<String,Object> entry : params.entrySet())
                {
                    if (1 == top)
                        queryString += " where";
                    else
                        queryString += " and";
                    queryString += " model."+entry.getKey()+"= :value"+entry.getKey();
                    top++;
                }
            if(nameorder != null)
            {
                queryString += " order by model."+nameorder;
                if(order)
                    queryString+=" ASC";
                else
                    queryString+=" DESC";
            }
            Query query = getEntityManager().createQuery(queryString);
            if (null != params && params.size()>0)
                for(Map.Entry<String,Object> entry : params.entrySet())
                    query.setParameter("value"+entry.getKey(), entry.getValue());
            if(page != null && size != null)
                query.setMaxResults(size.intValue()).setFirstResult(page.intValue() * size.intValue());
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find by property name*N failed",
                    Level.SEVERE, re);
            throw re;
        }
    }
      @SuppressWarnings("unchecked")
    public List<T> findByProperty(Map<String, Object> params,
                                  Integer page,Integer size,String nameorder,boolean order) {
        try {
            String queryString = "select model from " + getClassName() + " model";
            int top = 1;
            if (null != params && params.size()>0)
                for(Map.Entry<String,Object> entry : params.entrySet())
                {
                    if (1 == top)
                        queryString += " where";
                    else
                        queryString += " and";
                    queryString += " model."+entry.getKey()+"= :value"+entry.getKey();
                    top++;
                }
            if(nameorder != null)
            {
                queryString += " order by model."+nameorder;
                if(order)
                    queryString+=" ASC";
                else
                    queryString+=" DESC";
            }
            Query query = getEntityManager().createQuery(queryString);
            if (null != params && params.size()>0)
                for(Map.Entry<String,Object> entry : params.entrySet())
                    query.setParameter("value"+entry.getKey(), entry.getValue());
            if(page != null && size != null)
                query.setMaxResults(size.intValue()).setFirstResult(page.intValue() * size.intValue());
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find by property name*N failed",
                    Level.SEVERE, re);
            throw re;
        }
    }
    public long countByProperty(Map<String, Object> params ,Map<String, List<Object>> paramslist) {
        try {
            String queryString = "select count(model) from " + getClassName() + " model";
            int top = 1;
            if (null != paramslist && paramslist.size()>0)
                for(Map.Entry<String,List<Object>> entry : paramslist.entrySet())
                {
                    if(entry.getValue().size()>0)
                    {
                        if (1 == top)
                            queryString += " where";
                        else
                            queryString += " and";
                        queryString += " model."+entry.getKey()+" ";

                        for(int i=0;i<entry.getValue().size();i++)
                        {
                            if(i==0)
                                queryString += "in (";
                            else
                                queryString += ",";
                            queryString += "'"+entry.getValue().get(i)+"'";
                            if(i+1==entry.getValue().size())
                                queryString += ")";
                        }
                        top++;
                    }
                }
            if (null != params && params.size()>0)
                for(Map.Entry<String,Object> entry : params.entrySet())
                {
                    if (1 == top)
                        queryString += " where";
                    else
                        queryString += " and";
                    queryString += " model."+entry.getKey()+"= :value"+entry.getKey();
                    top++;
                }
            Query query = getEntityManager().createQuery(queryString);
            if (null != params && params.size()>0)
                for(Map.Entry<String,Object> entry : params.entrySet())
                    query.setParameter("value"+entry.getKey(), entry.getValue());
            Long count = (Long)query.getSingleResult();
            return count.longValue();
        } catch (RuntimeException re) {
            log("find by property name*N failed",
                    Level.SEVERE, re);
            throw re;
        }
    }
   public long countByProperty(Map<String, Object> params) {
        try {
            String queryString = "select count(model) from " + getClassName() + " model";
            int top = 1;
            if (null != params && params.size()>0)
                for(Map.Entry<String,Object> entry : params.entrySet())
                {
                    if (1 == top)
                        queryString += " where";
                    else
                        queryString += " and";
                    queryString += " model."+entry.getKey()+"= :value"+entry.getKey();
                    top++;
                }
            Query query = getEntityManager().createQuery(queryString);
            if (null != params && params.size()>0)
                for(Map.Entry<String,Object> entry : params.entrySet())
                    query.setParameter("value"+entry.getKey(), entry.getValue());
            Long count = (Long)query.getSingleResult();
            return count.longValue();
        } catch (RuntimeException re) {
            log("find by property name*N failed",
                    Level.SEVERE, re);
            throw re;
        }
    }
    @SuppressWarnings("unchecked")
    public List<T> findByProperty(String propertyName,
                                  final Object value, int page, int size) {
        log("finding " + getClassName() + " instance with property: "
                + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from " + getClassName() + " model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            query.setMaxResults(size).setFirstResult(page * size);
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find by property name failed",
                    Level.SEVERE, re);
            throw re;
        }
    }

     @SuppressWarnings("unchecked")
    public List<T> findAll() {
        log("finding all " + getClassName() + " instances", Level.INFO,
                null);
        try {
            final String queryString = "select model from " + getClassName() + " model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(int page, int size) {
        log("finding all " + getClassName() + " instances", Level.INFO,
                null);
        try {
            final String queryString = "select model from " + getClassName() + " model";
            Query query = getEntityManager().createQuery(queryString);
            query.setMaxResults(size).setFirstResult(page * size);
            return query.getResultList();
        } catch (RuntimeException re) {
            log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

    public long countAll(){
        log("count all " + getClassName() + "instances", Level.INFO,
                null);
        try {
            final String qlString = "select count(model)" +
                    " from " + getClassName() + " model";
            Query query = getEntityManager().createQuery(qlString);
            Long count = (Long)query.getSingleResult();
            return count.longValue();
        } catch (RuntimeException re) {
            log("count all failed", Level.SEVERE, re);
            throw re;
        }
    }

     public long countByProperty(String property, Object value){
        log("finding " + getClassName() + " instance with property: "
                + property + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select count(model)" +
                    " from " + getClassName() + " model" +
                    " where model." + property + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            Long count = (Long)query.getSingleResult();
            return count.longValue();
        } catch (RuntimeException re) {
            log("count by property name failed",
                    Level.SEVERE, re);
            throw re;
        }
    }

    public long countByProperty(String firstName, Object firstValue,
                                String secondName, Object secondValue){
        log("finding " + getClassName() + " instance with property1: "
                + firstName + ", value1: " + firstValue
                + "; propety2: "+ secondName + ", value2: " + secondValue, Level.INFO, null);
        try {
            final String queryString = "select count(model)" +
                    " from " + getClassName() + " model" +
                    " where model." + firstName + "= :value1" +
                    " and model." + secondName + "=:value2";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("value1", firstValue);
            query.setParameter("value2", secondValue);
            Long count = (Long)query.getSingleResult();
            return count.longValue();
        } catch (RuntimeException re) {
            log("count by property name2 failed",
                    Level.SEVERE, re);
            throw re;
        }
    }
}

