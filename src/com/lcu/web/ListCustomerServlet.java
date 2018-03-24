package com.lcu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.lcu.domain.Customer;
import com.lcu.service.CustomerService;
import com.lcu.service.Impl.CustomerServiceImpl;

/**
 * Servlet implementation class ListCustomerServlet
 */
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerService customer = new CustomerServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    //判断查询条件
	    String cust_name = request.getParameter("cust_name");
	    DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
	    
	    if (cust_name != null && !"".equals(cust_name)) {
            dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
            System.out.println(cust_name);
        }
	    
	    List<Customer>list = customer.getAll(dc);
	    
	    request.setAttribute("list", list);
	    request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	    
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
