package org.apache.struts.gps.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.gps.model.MasterPoint;
import org.apache.struts.gps.service.GpsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private MasterPoint masterpoint;
	
	private String message;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		
		if(latitude == null || longitude == null) {
			return ERROR;
		}
		
		masterpoint = new MasterPoint();
		masterpoint.setLatitude(Double.valueOf(latitude).doubleValue());
		masterpoint.setLongitude(Double.valueOf(longitude).doubleValue());
		GpsService.masterpoint = masterpoint;
		message = "Setting CompleteÅI";
		
		return SUCCESS;
	}

	public MasterPoint getMasterpoint() {
		return masterpoint;
	}

	public void setMasterpoint(MasterPoint masterpoint) {
		this.masterpoint = masterpoint;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
