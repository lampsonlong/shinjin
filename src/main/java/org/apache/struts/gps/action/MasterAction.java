package org.apache.struts.gps.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.common.util.CommonUtil;
import org.apache.struts.gps.constant.GpsConstant;
import org.apache.struts.gps.model.MasterPoint;
import org.apache.struts.gps.model.Position;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private MasterPoint masterpoint;
	
	private int ret;
	
	private Map<String, Position> ipMap;
	
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		
		CommonUtil util = new CommonUtil();
		HttpSession session = request.getSession();
		
		String latitude = request.getParameter("masterpoint.latitude");
		String longitude = request.getParameter("masterpoint.longitude");
		String ticketnumber = request.getParameter("masterpoint.ticket");
		String radius = request.getParameter("masterpoint.radius");
		
		if(util.isNullOrEmpty(latitude)
				|| util.isNullOrEmpty(longitude) 
				|| util.isNullOrEmpty(ticketnumber)
				|| util.isNullOrEmpty(radius)) {
			return "mlogin";
		}
		
		try {
			masterpoint = new MasterPoint();
			masterpoint.setLatitude(Double.valueOf(latitude).doubleValue());
			masterpoint.setLongitude(Double.valueOf(longitude).doubleValue());
			masterpoint.setTicket(Integer.parseInt(ticketnumber));
			masterpoint.setAllTicket(Integer.parseInt(ticketnumber));
			masterpoint.setRadius(Double.valueOf(radius).doubleValue());
		} catch (Exception e){
			ret = -1;
			return SUCCESS;
		}
		
		GpsConstant.setMasterPoint(masterpoint);
		session.setAttribute("setMaster", "OK");
		ret = 0;
		// reset ipList
		GpsConstant.setTicketIpList(null);
		
		return SUCCESS;
	}
	
	public String mview() throws Exception {
		masterpoint = new MasterPoint();
		setIpMap(new HashMap<String, Position>());
		
		setIpMap(GpsConstant.getTicketIpList());
		setMasterpoint(GpsConstant.getMasterPoint());
		
		if(masterpoint == null){
			return "master";
		}
		
		return SUCCESS;
	}
	
	public String mview2master() throws Exception {
		masterpoint = new MasterPoint();
		
		setMasterpoint(GpsConstant.getMasterPoint());
		
		return SUCCESS;
	}


	public MasterPoint getMasterpoint() {
		return masterpoint;
	}

	public void setMasterpoint(MasterPoint masterpoint) {
		this.masterpoint = masterpoint;
	}

	public Map<String, Position> getIpMap() {
		return ipMap;
	}

	public void setIpMap(Map<String, Position> ipMap) {
		this.ipMap = ipMap;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}
}
