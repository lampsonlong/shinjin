package org.apache.struts.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionFilterInterceptor extends AbstractInterceptor {  
	
    public String intercept(ActionInvocation invocation) throws Exception {  
        HttpSession session = ServletActionContext.getRequest().getSession();  
        if(session.getAttribute("userInfo") == null){
          HttpServletRequest request = ServletActionContext.getRequest();
          HttpServletResponse response = ServletActionContext.getResponse();
          //ServletActionContext.getResponse().sendRedirect(Action.INPUT);  
          session.invalidate();  
          response.setContentType("text/html;charset=utf-8");  
          PrintWriter out = response.getWriter();  
          out.println("<script language='javascript' type='text/javascript'>");  
          out.println("alert('Session Failed!');window.location.href='" + request.getContextPath() + "/mlogin.jsp'");  
          out.println("</script>");  
          return "none";
        }else{  
            return invocation.invoke();
        }
    }  
  
}  