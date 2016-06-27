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

public class MViewFilter implements Filter {
	public void destroy() {  
        // TODO Auto-generated method stub  
          
    }
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
        // TODO Auto-generated method stub  
        HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) res;  
        HttpSession session = request.getSession();  
        
        String url = request.getServletPath();
        
        if ("/mview.jsp".equals(url)) {
	        if (session.getAttribute("setMaster") == null) {  
	            session.invalidate();
	            response.setContentType("text/html;charset=utf-8");  
	            PrintWriter out = response.getWriter();  
	            out.println("<script language='javascript' type='text/javascript'>");  
	            out.println("alert('master data is none.!');window.location.href='" + request.getContextPath() + "/mlogin.jsp'");  
	            out.println("</script>");  
	        } else {  
	            chain.doFilter(request, response);
	        }
        } else {
        	chain.doFilter(request, response);
        }
    }
	
	public void init(FilterConfig arg0) throws ServletException {  
        // TODO Auto-generated method stub  
  
    } 
}
