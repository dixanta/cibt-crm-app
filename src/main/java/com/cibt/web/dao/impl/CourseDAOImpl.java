/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.dao.impl;

import com.cibt.web.dao.CourseDAO;
import com.cibt.web.entity.Course;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class CourseDAOImpl implements CourseDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    @Override
    public List<Course> getAll() {
        session=sessionFactory.openSession();
        return session.createQuery("select c from Course c")
                .list();
    }

    @Override
    public int insert(Course model) {
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        session.saveOrUpdate(model);
        transaction.commit();
        return model.getId();
    }
    
}
