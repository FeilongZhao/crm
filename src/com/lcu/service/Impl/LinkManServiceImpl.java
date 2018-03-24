package com.lcu.service.Impl;

import com.lcu.dao.CustomerDao;
import com.lcu.dao.LinkManDao;
import com.lcu.dao.Impl.CustomerDaoImpl;
import com.lcu.dao.Impl.LinkManDaoImpl;
import com.lcu.domain.Customer;
import com.lcu.domain.LinkMan;
import com.lcu.service.CustomerService;
import com.lcu.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {

    private CustomerDao customerDao = new CustomerDaoImpl();
    private LinkManDao lmd = new LinkManDaoImpl();
    public void save(LinkMan lm) {
       Integer cust_id = lm.getCust_id();
       Customer customer = customerDao.getById(cust_id);
       System.out.println(customer);
       lm.setCustomer(customer);
       lmd.save(lm);
    }

}
