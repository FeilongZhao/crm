package com.lcu.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {

        Map<String, Object> session = ActionContext.getContext().getSession();
        Object object = session.get("user");
        //session.get("user");
        System.out.println("object   "+object);
        if (object == null) {
            return "toLogin";
        }else {
            return  invocation.invoke();
        }
    }

}
