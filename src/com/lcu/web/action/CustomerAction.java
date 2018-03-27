package com.lcu.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lcu.domain.Customer;
import com.lcu.service.CustomerService;
import com.lcu.service.Impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    
    private List<Customer> all;
    private Customer customer = new Customer();
    private ServletContext sc;
    private WebApplicationContext ac;
    
    public String list() throws Exception {
        
        
        sc = ServletActionContext.getServletContext();
        ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        CustomerService customerService = (CustomerService) ac.getBean("customerService");
        
        String cust_name = (String)ServletActionContext.getRequest().getParameter("cust_name");
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        System.out.println(cust_name);
        if (StringUtils.isNotBlank(cust_name)) {
            dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
            System.out.println(cust_name);
        }
        
        all = customerService.getAll(dc);
        //ServletActionContext.getRequest().setAttribute("list", all);
        ActionContext.getContext().put("list", all);
        return "list";
    }

    public Customer getModel() {
        // TODO Auto-generated method stub
        return customer;
    }

    public String add() throws Exception {
        
        
        
        sc = ServletActionContext.getServletContext();
        ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        CustomerService customerService = (CustomerService) ac.getBean("customerService");
        customerService.add(customer);
        
        return "toList";
    }

    
    
    
    
    
}
