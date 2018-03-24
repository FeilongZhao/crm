package com.lcu.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.lcu.domain.LinkMan;
import com.lcu.service.LinkManService;
import com.lcu.service.Impl.LinkManServiceImpl;

/**
 * Servlet implementation class AddLinkManServlet
 */
public class AddLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LinkManService lms = new LinkManServiceImpl();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    LinkMan lm = new LinkMan();
	    try {
            BeanUtils.populate(lm, request.getParameterMap());
            System.out.println(lm);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    lms.save(lm);
	    response.sendRedirect(request.getContextPath() + "/ListLinkManServlet");
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
