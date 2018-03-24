package com.lcu.service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lcu.dao.CustomerDao;
import com.lcu.dao.Impl.CustomerDaoImpl;
import com.lcu.domain.Customer;
import com.lcu.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    public void add(Customer customer) {
       
        customerDao.save(customer);
        
    }

    public List<Customer> getAll() {
        
        List<Customer>list =  customerDao.getAll();
        
        return list;
    }

    public List<Customer> getAll(DetachedCriteria dc) {
        List<Customer>list =  customerDao.getAll(dc);
        return list;
    }

}
