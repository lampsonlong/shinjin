package org.apache.struts.gps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.gps.model.MasterPoint;
import org.apache.struts.gps.service.GpsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private MasterPoint masterpoint;
	
	private int ticket;
	
	private String message;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		HttpSession session = request.getSession();
		
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String ticketnumber = request.getParameter("ticketnumber");
		
		if(latitude == null || 
			longitude == null || 
			ticketnumber == null) {
			return ERROR;
		}
		
		masterpoint = new MasterPoint();
		masterpoint.setLatitude(Double.valueOf(latitude).doubleValue());
		masterpoint.setLongitude(Double.valueOf(longitude).doubleValue());
		setMessage("Setting Complete !");
		setTicket(Integer.parseInt(ticketnumber));
		GpsService.setMasterpoint(masterpoint);
		GpsService.setMasterTicket(getTicket());
		session.setAttribute("setMaster", "OK");
		
		return SUCCESS;
	}
	
	public String ticket() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		masterpoint = new MasterPoint();
		setMasterpoint(GpsService.getMasterpoint());
		
		setTicket(GpsService.getMasterTicket());
		
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

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
}
