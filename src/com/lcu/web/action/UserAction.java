package com.lcu.web.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lcu.domain.User;
import com.lcu.service.CustomerService;
import com.lcu.service.UserService;
import com.lcu.service.Impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

    private User user = new User();
    
    public User getModel() {
        // TODO Auto-generated method stub
        return user;
    }

 
    public String login() throws Exception {


        ServletContext sc = ServletActionContext.getServletContext();
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        UserService userService = (UserService) ac.getBean("userService");
        
        
        
        User u = userService.login(user);
        ActionContext.getContext().getSession().put("user", u);
        
        System.out.println("user   u  " + ActionContext.getContext().get("user"));
        
        return "toHome";
    }

    
    
}
