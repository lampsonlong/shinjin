package org.apache.struts.gps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MLoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private static final String pwd = "a123";
	
	private static final String userInfo = "bPfeWr1!asd53K0";
	
	private String errMsg;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		String password = request.getParameter("hidpwd");
		
		if(password == null || !pwd.equals(password)) {
			setErrMsg("Password Invalid !");
			return "failed";
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("userInfo", userInfo);
		
		return SUCCESS;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
