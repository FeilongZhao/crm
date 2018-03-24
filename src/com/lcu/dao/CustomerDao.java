package com.lcu.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lcu.domain.Customer;

public interface CustomerDao {

    void save(Customer customer);

    List<Customer> getAll();

    Customer getById(Integer cust_id);

    List<Customer> getAll(DetachedCriteria dc);

}
