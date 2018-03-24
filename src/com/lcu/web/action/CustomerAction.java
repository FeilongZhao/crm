package com.lcu.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.lcu.domain.Customer;
import com.lcu.service.CustomerService;
import com.lcu.service.Impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport{

    private CustomerService customerService = new CustomerServiceImpl();
    private List<Customer> all;
    
    public String list() throws Exception {
        
        String cust_name = (String)ServletActionContext.getRequest().getParameter("cust_name");
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        System.out.println(cust_name);
        if (StringUtils.isNotBlank(cust_name)) {
            dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
            System.out.println(cust_name);
        }
        
        all = customerService.getAll(dc);
        ServletActionContext.getRequest().setAttribute("list", all);
        return "list";
    }

    
    
}
