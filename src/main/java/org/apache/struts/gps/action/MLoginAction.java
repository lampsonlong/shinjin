package org.apache.struts.gps.action;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.common.util.CommonUtil;
import org.apache.struts.gps.constant.GpsConstant;
import org.apache.struts.gps.model.MasterPoint;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MLoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String errMsg;
	
	private MasterPoint masterPoint;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		CommonUtil util = new CommonUtil();
		HttpSession session = request.getSession();
		
		String password = request.getParameter("password");
		
		if(password == null || !GpsConstant.getPwd().equals(password)) {
			if(util.isLogin(session)){
				masterPoint = GpsConstant.getMasterPoint();
				return SUCCESS;
			} else{
				setErrMsg("Password Invalid !");
				return "failed";
			}
		}
		
		UUID uuid = UUID.randomUUID();
		GpsConstant.setUserinfo(uuid.toString());
		session.setAttribute("userInfo", uuid);
		
		masterPoint = GpsConstant.getMasterPoint();
		
		return SUCCESS;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public MasterPoint getMasterPoint() {
		return masterPoint;
	}
}
