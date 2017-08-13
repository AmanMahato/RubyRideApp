package com.rubyride.daoImpl;

import com.rubyride.dao.PresidentNameDao;
import com.rubyride.model.President;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author Aman Mahato
 */

@Repository
public class PresidentNameDaoImpl implements PresidentNameDao {


    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void persist(President president) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(president);

    }

    public President findByBirthOrder(Integer id) {
        Session session=this.sessionFactory.getCurrentSession();
        President p=(President) session.load(President.class, new Integer(id.intValue()));
        return p;
    }

    public List<President> findAll() {
        Session session=this.sessionFactory.getCurrentSession();
        List<President> presidentList=session.createQuery("From PresidentInfo").list();
        return presidentList;
    }
}
