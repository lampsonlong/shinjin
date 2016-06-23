package org.apache.struts.common;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionFilterInterceptor extends AbstractInterceptor {  
	
    public String intercept(ActionInvocation invocation) throws Exception {  
        /*HttpSession session = ServletActionContext.getRequest().getSession();  
        if(session.getAttribute("userInfo") == null){  
          HttpServletResponse response = ServletActionContext.getResponse();  
          ServletActionContext.getResponse().sendRedirect(Action.INPUT);  
          session.invalidate();  
          response.setContentType("text/html;charset=utf-8");  
          PrintWriter out = response.getWriter();  
          out.println("<script language='javascript' type='text/javascript'>");  
          out.println("alert('session failed!');window.location.href='/index.jsp'");  
          out.println("</script>");  
          return "none";  
          //return Action.INPUT;  
        }else{  
            return invocation.invoke();
        }  */
    	
    	return invocation.invoke();
    }  
  
}  