/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.dao.impl;

import com.cibt.web.dao.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author USER
 */
public abstract class GenericDAOImpl<T> implements 
        GenericDAO<T>{
    @Autowired
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction transaction;
    
    protected Class<?> persistClass;
    
    public GenericDAOImpl() {
        persistClass=(Class<?>)(
                (ParameterizedType)
                        getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
    
    
    
    @Override
    public void save(T model) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(model);
        transaction.commit();
    }
    
    @Override
    public T getById(int id) {
        session = sessionFactory.openSession();
        return (T)session.get(persistClass, id);

    }
    
    @Override
    public boolean delete(int id) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        T model = getById(id);
        if (model != null) {
            session.delete(model);
            transaction.commit();
            return true;
        }
        return false;
    }
    
    @Override
    public List<T> getAll() {
        System.out.println("I was here");
        session = sessionFactory.openSession();
        CriteriaQuery
                query=session.getCriteriaBuilder()
                .createQuery(persistClass);
         query.from(persistClass);
        return session.createQuery(query).getResultList();
                
    }

}
