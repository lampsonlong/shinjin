package org.apache.struts.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.common.util.CommonUtil;

public class MyFilter implements Filter {
	
	public void destroy() {  
        // TODO Auto-generated method stub  
          
    }
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
        // TODO Auto-generated method stub  
        HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) res;  
        
        String url = request.getServletPath();
        boolean toMLogin = false;
        boolean toIndex = false;
        
        
        if("/index.jsp".equals(url)){
        	response.setContentType("text/html;charset=utf-8");  
            PrintWriter out = response.getWriter();  
            out.println("<script language='javascript' type='text/javascript'>");  
            out.println("window.location.href='" + request.getContextPath() + "/gps.action'");  
            out.println("</script>");
        } else if("/mlogin.jsp".equals(url)
        		|| url.endsWith(".js")
        		|| url.endsWith(".css")
        		|| url.endsWith("gps.action")
        		|| url.endsWith("mlogin.action")){
        	// no check
        } else if (url.endsWith(".action")){
        	// check login
        	HttpSession session = request.getSession();
        	CommonUtil util = new CommonUtil();
        	if(!util.isLogin(session)){
        		toMLogin = true;
        	}
        } else if (url.startsWith("/m")
        		&& url.endsWith(".jsp")){
        	toMLogin = true;
        } else {
        	// not exist page
        	toIndex = true;
        }
        
        if (toIndex){
        	response.setContentType("text/html;charset=utf-8");  
            PrintWriter out = response.getWriter();  
            out.println("<script language='javascript' type='text/javascript'>");  
            out.println("window.location.href='" + request.getContextPath() + "/'");  
            out.println("</script>");  
        } else if(toMLogin){
        	response.setContentType("text/html;charset=utf-8");  
            PrintWriter out = response.getWriter();  
            out.println("<script language='javascript' type='text/javascript'>");  
            out.println("window.location.href='" + request.getContextPath() + "/mlogin.jsp'");
            out.println("</script>");
        } else {
        	chain.doFilter(request, response);
        }
    }
	
	public void init(FilterConfig arg0) throws ServletException {  
        // TODO Auto-generated method stub  
  
    } 

}
