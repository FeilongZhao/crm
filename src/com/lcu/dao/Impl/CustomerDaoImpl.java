package com.lcu.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.lcu.dao.CustomerDao;
import com.lcu.domain.Customer;
import com.lcu.utils.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

    private Session session;
    private Transaction beginTransaction;
    private List<Customer> list;
    private Customer customer;

    public void save(Customer customer) {
        
        session = HibernateUtil.openSession();
        beginTransaction = session.beginTransaction();
        session.save(customer);
        beginTransaction.commit();
        session.close();
        
    }

    public List<Customer> getAll() {
       
        
        session = HibernateUtil.openSession();
        beginTransaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        list = criteria.list();
        beginTransaction.commit();
        session.close();
        return list;
    }

    public Customer getById(Integer cust_id) {
        
        session = HibernateUtil.openSession();
        beginTransaction = session.beginTransaction();
        customer = session.get(Customer.class,cust_id);
        System.out.println(customer + "111");
        System.out.println(cust_id);
        beginTransaction.commit();
        session.close();
        
        return customer;
    }

    public List<Customer> getAll(DetachedCriteria dc) {
        session = HibernateUtil.openSession();
        Criteria criteria = dc.getExecutableCriteria(session);
        
        return criteria.list();
    }

}
