package com.lcu.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lcu.domain.Customer;

public interface CustomerService {

    void add(Customer customer);

    List<Customer> getAll();
//
    List<Customer> getAll(DetachedCriteria dc);

}
