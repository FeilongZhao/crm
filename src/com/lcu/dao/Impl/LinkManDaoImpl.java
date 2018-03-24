package com.lcu.dao.Impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lcu.dao.LinkManDao;
import com.lcu.domain.LinkMan;
import com.lcu.utils.HibernateUtil;

public class LinkManDaoImpl implements LinkManDao {

    private Session session;
    private Transaction beginTransaction;

    public void save(LinkMan lm) {
        session = HibernateUtil.openSession();
        beginTransaction = session.beginTransaction();
        session.save(lm);
        beginTransaction.commit();
        session.close();

    }

}
